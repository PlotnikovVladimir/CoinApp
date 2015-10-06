<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>AngularJS and JSP</title>
  <script src="${pageContext.request.contextPath}/lib/angular/angular.min.js"></script>
  <script src="${pageContext.request.contextPath}/lib/angular/angular-route.min.js"></script>
  <script src="${pageContext.request.contextPath}/lib/angular/angular-ui-router.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
  <script src="${pageContext.request.contextPath}/lib/boostrap/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/lib/boostrap/bootstrap-dropdown.js"></script>
  <script src="${pageContext.request.contextPath}/lib/jquery-2.1.3.min.js"></script>

  <script src="${pageContext.request.contextPath}/old_temp/view1.js"></script>
</head>
<body>
  <div class="container" ng-app="NewApp" ng-controller="newCoinCntr">
    view1 :
    {{message}}
    <p>......</p>
    <p>description</p>
    <input type="text" ng-model="description"/>
    <p>name</p>
    <input type="text" ng-model="name"/>
    <p>year</p>
    <input type="text" ng-model="yearCa"/>
    <p>________________________________</p>
    <label>Avers : </label>
    <input type="file" data-fileread="fileImg1" required>
    <div>{{fileImg1}}</div>
    <p></p>
    <label>Revers : </label>
    <input type="file" data-fileread="fileImg2" required>
    <div>{{fileImg2}}</div>
    <p></p>

  <%--<input type="file" ng-model="file" name="file" id="file" accept="image/*"/>--%>
    <%--<input type="file" file-model="myFile"/>--%>
    <%--<input type="file" ng-file-select="onFileSelect($files)">--%>
    <%--<input name="file" type="file" id="fileImg" ng-model="selectedFile" />--%>
    <%--<input type="file" multiple onchange="angular.element(this).$scope.uploadedFile(this)"/>--%>
    <%--Picture: <input type="file" ngf-select="" ng-model="picFile" name="file" accept="image/*" required="">--%>
    <button ng-click="saveCoin()">Save</button>
    <img ngf-src="picFile" class="thumb">
    <p></p>
    <a ng-href="#" ng-click="saveCoin()">Save</a>
  </div>
</body>
</html>
