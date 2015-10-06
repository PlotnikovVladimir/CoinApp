<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="ui.bootstrap.demo">
<head>
  <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.js"></script>
  <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular-animate.js"></script>
  <script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.13.4.js"></script>
  <script src="${pageContext.request.contextPath}/old_temp/example.js"></script>
  <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
    <title></title>
</head>
<body>
<div ng-controller="ModalDemoCtrl">
  <script type="text/ng-template" id="myModalContent.html">
    <div class="modal-header">
      <h3 class="modal-title">I'm a modal!</h3>
    </div>
    <div class="modal-body">
      <ul>
        <li ng-repeat="item in items">
          <a href="#" ng-click="$event.preventDefault(); selected.item = item">{{ item }}</a>
        </li>
      </ul>
      Selected: <b>{{ selected.item }}</b>
    </div>
    <div class="modal-footer">
      <button class="btn btn-primary" type="button" ng-click="ok()">OK</button>
      <button class="btn btn-warning" type="button" ng-click="cancel()">Cancel</button>
    </div>
  </script>

  <button type="button" class="btn btn-default" ng-click="open()">Open me!</button>
  <button type="button" class="btn btn-default" ng-click="open('lg')">Large modal</button>
  <button type="button" class="btn btn-default" ng-click="open('sm')">Small modal</button>
  <button type="button" class="btn btn-default" ng-click="toggleAnimation()">Toggle Animation ({{ animationsEnabled }})</button>
  <div ng-show="selected">Selection from a modal: {{ selected }}</div>
</div>
</body>
</html>
