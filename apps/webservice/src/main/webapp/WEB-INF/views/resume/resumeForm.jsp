<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<title>Resume Manage</title>
</head>

<body>
	<form id="inputForm" action="${ctx}/job/${action}" method="post"
		class="form-horizontal">
		<input type="hidden" name="id" value="${resume.id}" />
		<fieldset>
			<legend>
				<small>Manage Job</small>
			</legend>

			<div class="control-group">
				<label for="job_name" class="control-label">Name:</label>
				<div class="controls">
					<input type="text" id="name" name="name" value="${resume.name}"
						class="input-large required" minlength="3" />
				</div>
			</div>
			
			
			<div class="control-group">
				<label for="description" class="control-label">Status</label>
				<div class="controls">
					<input type="text" id="status" name="status" class="input-large">${resume.status}</input>
				</div>
			</div>
			
			<div class="control-group">
				<label for="description" class="control-label">Skills</label>
				<div class="controls">
					<textarea id="description" name="description" class="input-large" >${resume.skills}</textarea>
				</div>
			</div>
			
			<div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit"
					value="Submit" />&nbsp; <input id="cancel_btn" class="btn"
					type="button" value="Return" onclick="history.back()" />
			</div>
		</fieldset>
	</form>
	<script>
		$(document).ready(function() {
			$("#job_name").focus();
			$("#inputForm").validate();
			$('#status').autocomplete({
				serviceUrl: '${pageContext.request.contextPath}/api/v1/type/resumestatus',
				paramName: "name",
				delimiter: ",",
			   	transformResult: function(response) {
				return {      	
				  suggestions: $.map($.parseJSON(response), function(item) {      	
				      return { value: item.name, data: item.id };
				   })        
				 };
		        }    
			 });
		});
	</script>
</body>
</html>
