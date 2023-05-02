package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.study.demo.domain.Supplier;

@Mapper
public interface Mapper09 {

	@Select("""
			<script>
			SELECT COUNT(*)
			FROM Customers
			WHERE Country IN (
			
			<foreach collection="elems" item="elem" separator=",">
				#{elem}
			</foreach>
			
			)
			</script>
			
			""")
	Integer sql1(List<String> elems);

	@Select("""
			<script>
			SELECT 
				SupplierId id,
				SupplierName name,
				contactName,
				address,
				city,
				postalCode,
				country,
				phone
			FROM Suppliers
			<where>
			
			<if test="countryList neq null">
				
			Country IN (
				<foreach collection="countryList" item="country" separator=",">
					#{country}
				</foreach>
			)
			
			</if>
			
			</where>
			</script>
			""")
	List<Supplier> sql2(List<String> countryList);
}
