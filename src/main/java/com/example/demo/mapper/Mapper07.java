package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.study.demo.domain.Customer;
import com.study.demo.domain.Employee;

@Mapper
public interface Mapper07 {

	@Select("""
			<script>
			<bind name="pattern" value="'%' + keyword+ '%'" />

			SELECT
				customerId id,
				customerName name,
				address,
				contactName
			FROM
				Customers
			WHERE
				CustomerName LIKE #{pattern}
			ORDER BY id DESC
			</script>
			""")
	List<Customer> sql1(String keyword);

	@Select("""
			<script>
			<bind name="pattern" value="'%' + search + '%'" />

			SELECT
				EmployeeId id,
				firstName,
				lastName
			FROM
				Employees
			WHERE
				firstName LIKE #{pattern} OR lastName LIKE #{pattern}
				ORDER BY lastName DESC
			</script>
			""")
	List<Employee> sql2(String search);

	@Select("""
			<script>
			SELECT COUNT(*)
			FROM Customers

			<if test="false">
			WHERE CustomerID = 10
			</if>
			</script>
			""")
	Integer sql3();

	@Select("""
			<script>
			SELECT COUNT(*)
			FROM Customers

			<if test="keyword neq null">
				<bind name="pattern" value="'%' + keyword + '%'"/>
				WHERE CustomerName LIKE #{pattern}
			</if>
			</script>
			""")
	Integer sql4(String keyword);

	// operator : https://commons.apache.org/proper/commons-ognl/language-guide.html
	@Select("""
			<script>
			SELECT AVG(Price)
			FROM Products

			<if test="i neq 0">
				<bind name = "pattern" value = "i"/>
				WHERE CategoryID = #{pattern}
			</if>
			</script>
			""")
	Double sql5(int i);
}
