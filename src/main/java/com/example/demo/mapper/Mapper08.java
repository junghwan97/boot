package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Mapper08 {

	@Select("""
			<script>
			SELECT COUNT(*)
			FROM Customers
			<where>
				<if test="id lt 5">
				
				</if>
			</where>
			</script>
			""")
	public Integer sql1();
	
	@Select("""
			
			SELECT(*)
			FROM Customers
			WHERE CustoemrId < #{id}
			""")
	public Integer sql2(Integer id);

	
	// Caused by: org.xml.sax.SAXParseException: 요소 콘텐츠는 올바른 형식의 문자 데이터 또는 마크업으로 구성되어야 합니다.
	// WHERE CustomerId < #{id}
	// ->  WHERE CustomerId &lt; #{id}
	@Select("""
			<script>
			SELECT(*)
			FROM Customers
			WHERE CustomerId &lt; #{id}
			</script>
			""")
	public Integer sql3(Integer id);
	
	
	@Select("""
			<script>
			
			<![CDATA[
			
			SELECT(*)
			FROM Customers
			WHERE CustomerId < #{id}
			
			]]>
			
			<where>
				 	<if test="true">
				 	
				 	<![CDATA[
				 	
				 	OR CustomerId < #{id}
				 
				 	]]>
				 
				 	</if>
			 </where>
			 
			</script>
			""")
	public Integer sql4();
}
