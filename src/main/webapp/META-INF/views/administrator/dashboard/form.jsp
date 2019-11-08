<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<h2>
	<acme:message code="administrator.dashboard.form.message"/>
</h2>
<div>
	<canvas id="canvas"></canvas>
</div>
</br>
<div>
	<canvas id="canvas2"></canvas>
</div>

<script type="text/javascript">	
	$(document).ready(function() {
		var data = {
			labels: [
				<jstl:forEach var="iterator" items="${numberOfCompaniesGroupedBySector}">
					"<jstl:out value="${iterator[0]}"/>" ,
				</jstl:forEach>
			],
			datasets: [
				{
					data: [
						<jstl:forEach var="iterator" items="${numberOfCompaniesGroupedBySector}">
							<jstl:out value="${iterator[1]}"/> ,
						</jstl:forEach>
					]
				}
			]
		};
		
		
		
		var options = {
			scales : {
				yAxes:[
					{
						ticks : {
							suggestedMin : 0.0,
							suggestedMax : 1.0
						}
					}
				]
			},
			legend : {
				display : false
			}
		};
		
		var canvas, context;
		
		canvas = document.getElementById("canvas");
		context = canvas.getContext("2d");
		new Chart(context, {
			type: "pie",
			data: data,
			options: options
		});
		
	});
		
</script>

<script type="text/javascript">	
	$(document).ready(function() {
		var data = {
				labels: [
					<jstl:forEach var="iterator" items="${numberOfInvestorsGroupedBySector}">
						"<jstl:out value="${iterator[0]}"/>" ,
					</jstl:forEach>
				],
				datasets: [
					{
						data: [
							<jstl:forEach var="iterator" items="${numberOfInvestorsGroupedBySector}">
								<jstl:out value="${iterator[1]}"/> ,
							</jstl:forEach>
						]
					}
				]
			};
		
		var options = {
				scales : {
					yAxes:[
						{
							ticks : {
								suggestedMin : 0.0,
								suggestedMax : 1.0
							}
						}
					]
				},
				legend : {
					display : false
				}
			};
			
		var canvas, context;
			
		canvas = document.getElementById("canvas2");
		context = canvas.getContext("2d");
		new Chart(context, {
			type: "pie",
			data: data,
			options: options
		});
			
	});
</script>