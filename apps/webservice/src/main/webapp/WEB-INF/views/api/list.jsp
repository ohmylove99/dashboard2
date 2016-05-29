<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="reqUrl"
	value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}" />

<html>
<head>
<title>Restful API</title>
</head>

<body>

	<h3>Restful API</h3>
	<h4>API</h4>
	<ul>
		<li>Task List: <a href="${reqUrl}/api/v1/task">${reqUrl}/api/v1/task</a></li>
		<li>Task Get(id=1) : <a href="${reqUrl}/api/v1/task/1">${reqUrl}/api/v1/task/1</a></li>
		
		<li>Project List: <a href="${reqUrl}/api/v1/project">${reqUrl}/api/v1/project</a></li>
		<li>Project Get(id=1) : <a href="${reqUrl}/api/v1/project/1">${reqUrl}/api/v1/project/1</a></li>
		
		<li>Resume List: <a href="${reqUrl}/api/v1/resume">${reqUrl}//api/v1/resume</a></li>
		<li>Resume Get(id=1) : <a href="${reqUrl}/api/v1/resume/1">${reqUrl}/api/v1/resume/1</a></li>
		
		<li>Job List: <a href="${reqUrl}/api/v1/job">${reqUrl}//api/v1/job</a></li>
		<li>Job Get(id=1) : <a href="${reqUrl}/api/v1/job/1">${reqUrl}/api/v1/job/1</a></li>
		
		<li>Type - EmpType List: <a href="${reqUrl}/api/v1/emptype">${reqUrl}//api/v1/emptype</a></li>
		<li>Type - EmpType Get(id=1) : <a href="${reqUrl}/api/v1/emptype/1">${reqUrl}/api/v1/emptype/1</a></li>
		
		<li>Type - InterviewRound List: <a href="${reqUrl}/api/v1/interviewround">${reqUrl}/api/v1/interviewround</a></li>
		<li>Type - InterviewRound Get(id=1) : <a href="${reqUrl}/api/v1/interviewround/1">${reqUrl}/api/v1/interviewround/1</a></li>
		
		<li>Type - InterviewStatus List: <a href="${reqUrl}/api/v1/interviewstatus">${reqUrl}/api/v1/interviewstatus</a></li>
		<li>Type - InterviewStatus Get(id=1) : <a href="${reqUrl}/api/v1/interviewstatus/1">${reqUrl}/api/v1/interviewstatus/1</a></li>
		
		<li>Type - JobBiz List: <a href="${reqUrl}/api/v1/jobbiz">${reqUrl}/api/v1/jobbiz</a></li>
		<li>Type - JobBiz Get(id=1) : <a href="${reqUrl}/api/v1/jobbiz/1">${reqUrl}/api/v1/jobbiz/1</a></li>
		
		<li>Type - JobGrade List: <a href="${reqUrl}/api/v1/jobgrade">${reqUrl}/api/v1/jobgrade</a></li>
		<li>Type - JobGrade Get(id=1) : <a href="${reqUrl}/api/v1/jobgrade/1">${reqUrl}/api/v1/jobgrade/1</a></li>
		
		<li>Type - JobStatus List: <a href="${reqUrl}/api/v1/jobstatus">${reqUrl}/api/v1/jobstatus</a></li>
		<li>Type - JobStatus Get(id=1) : <a href="${reqUrl}/api/v1/jobstatus/1">${reqUrl}/api/v1/jobstatus/1</a></li>
		
		<li>Type - ResumeStatus List: <a href="${reqUrl}/api/v1/resumestatus">${reqUrl}/api/v1/resumestatus</a></li>
		<li>Type - ResumeStatus Get(id=1) : <a href="${reqUrl}/api/v1/resumestatus/1">${reqUrl}/api/v1/resumestatus/1</a></li>
	</ul>

	<h4>Update API</h4>
	<ul>
		<li>Create task: ${reqUrl}/api/v1/task method=Post, consumes=JSON</li>
		<li>Update task: (id=1) ：${reqUrl}/api/v1/task/1 method=Put,
			consumes=JSON</li>
	</ul>
</body>
</html>
