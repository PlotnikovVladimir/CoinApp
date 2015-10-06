<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 10.09.2015
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
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
    <script src="${pageContext.request.contextPath}/lib/boostrap/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/lib/boostrap/bootstrap-dropdown.js"></script>
    <script src="${pageContext.request.contextPath}/lib/jquery-2.1.3.min.js"></script>

    <script src="${pageContext.request.contextPath}/js/index.js"></script>
  <%--<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular-animate.js"></script>--%>
  <%--<script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.13.4.js"></script>--%>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/ng-dialog/0.5.1/js/ngDialog.min.js"></script>
  <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/ng-dialog/0.5.1/js/ngDialog.js"></script>--%>
  <script src="${pageContext.request.contextPath}/lib/ngDialog.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ng-dialog/0.5.1/css/ngDialog.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ng-dialog/0.5.1/css/ngDialog.css">


  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
  <!-- Scripts -->

</head>
<body>

  <nav class="navbar navbar-default" role="navigation">
    <div class="container">

      <div class="navbar-header">
        <a class="navbar-brand" href="/"><span></span>&nbsp;Home</a>
      </div>

      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

        <ul class="nav navbar-nav navbar-right">
          <li><a href="#">Link</a></li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="#">Действие</a></li>
              <li><a href="#">Другое действие</a></li>
              <li><a href="#">Что-то еще</a></li>
              <li class="divider"></li>
              <li><a href="#">Отдельная ссылка</a></li>
            </ul>
          </li>
        </ul>
      </div><!-- /.navbar-collapse -->
    </div>
  </nav>


  <!-- Page Content -->
  <div class="container" ng-app = "categoriesApp" ng-controller = "CategoryCntr">

    <script type="text/ng-template" id="templateId2">
      <div class="dialog-contents">
        <h1>Template heading</h1>
        <p>Content goes here</p>

      </div>
    </script>
    <a ng-href="#" ng-click="opendia2('qwqwqwewqwq')">Open Dia NEW</a>

    <%--<div ng-controller="modalCnt">--%>
    <%--<script type="text/ng-template" id="myModalContent.html">--%>
      <%--<div class="modal-header">--%>
        <%--<h3 class="modal-title">I'm a modal!</h3>--%>
      <%--</div>--%>
      <%--<div class="modal-body">--%>
        <%--<ul>--%>
          <%--<li ng-repeat="item in items">--%>
            <%--<a href="#" ng-click="$event.preventDefault(); selected.item = item">{{ item }}</a>--%>
          <%--</li>--%>
        <%--</ul>--%>
        <%--Selected: <b>{{ selected.item }}</b>--%>
      <%--</div>--%>
      <%--<div class="modal-footer">--%>
        <%--<button class="btn btn-primary" type="button" ng-click="ok()">OK</button>--%>
        <%--<button class="btn btn-warning" type="button" ng-click="cancel()">Cancel</button>--%>
      <%--</div>--%>
    <%--</script>--%>

    <%--<button type="button" class="btn btn-default" ng-click="open('lg')">Large modal</button>--%>
    <%--<div ng-show="selected">Selection from a modal: {{ selected }}</div>--%>
    <%--</div>--%>


    <div class="row" ng-controller="CategCntr">

      <script type="text/ng-template" id="templateId">
        <div class="dialog-contents">
          <h1>Template heading</h1>
          <p>Content goes here</p>
          Some message
          <button ng-click="closeThisDialog()">Cancel</button>
          <button ng-click="confirm()">Confirm</button>
        </div>
      </script>

    <a ng-href="#" ng-click="opendia('qwqwqwewqwq')">Open Dia</a>

      <div class="col-md-3" >
        <%--<div class="list-group">--%>
            <li>
              <a ng-href="#" ng-click="showAll()" style="color:#0000FF">Show All</a>
            </li>

            <li ng-repeat="category in categories | filter:{parentCategory:0}">
              <a ng-href="#" ng-click="showCategory(category.id, category.name)" ng-init="parentI = category.id">{{category.name}}</a>
              <ul ng-repeat="subcategory in categories | filter:{parentCategory:parentI}">
                <a ng-href="#" ng-click="showSubCategory(subcategory.id, subcategory.name)">{{subcategory.name}}</a>
              </ul>
            </li>
          <p>Temp row .......1list</p>
          <p>${pageContext.request.remoteUser}</p>
          <p><a ui-sref="view1">Route1</a></p>
          <p>Temp row .......3list</p>
          <p>Temp row .......4list</p>
        <%--</div>--%>
      </div>

      <div class="col-md-9">
        <div class="thumbnail">
          <div id="contentCoins">
            <article ng-repeat="coin in coinsForView | filter:{category:forFilter}">
              <img ng-src="${pageContext.request.contextPath}/img/{{coin.id}}a.jpg" border="2" height="85" width="100">
              <img ng-src="${pageContext.request.contextPath}/img/{{coin.id}}r.jpg" border="2" height="85" width="100">
              <a ng-href="#">
                <span>description: {{coin.year}} {{coin.name}}  {{coin.description}} {{coin.category.name}}</span>
              </a>
              <p></p>
            </article>
            <p>Temp row .......Content1</p>
            <p>Temp row .......Content2</p>
            <p>Temp row .......Content3</p>
            <p>Temp row .......Content4</p>

          </div>
        </div>
      </div>

    </div>

  </div>
  <!-- /.container -->



  <%--<div ui-view>--%>
  <%--<p>JSP</p>--%>
  <%--<div class="col-xs-2" ng-app = "mainApp" ng-controller = "TestController">--%>
    <%--<p>--%>
      <%--Filter <input ng-model="query">--%>
    <%--</p>--%>
    <%--<ul>--%>
      <%--<li ng-repeat="x in names | filter:query">--%>
        <%--<label id="some-{{x.length}}">{{x.length}}</label>--%>
        <%--&lt;%&ndash;<img src="${pageContext.request.contextPath}/img/{{x.length}}.jpg">&ndash;%&gt;--%>
        <%--<p></p>--%>
        <%--{{x.type + " -  " + x.length + "  -  " + x.heigth}}--%>
      <%--</li>--%>
    <%--</ul>--%>

    <%--<p>.........................</p>--%>
    <%--{{coins}}--%>
    <%--<ul>--%>
      <%--<li ng-repeat="coin in coins">--%>
        <%--<label>{{coin.name}}</label>--%>
        <%--<img ng-src="${pageContext.request.contextPath}/img/{{coin.id}}a.jpg">--%>
        <%--<img ng-src="${pageContext.request.contextPath}/img/{{coin.id}}r.jpg">--%>
      <%--</li>--%>
    <%--</ul>--%>

    <%--<p>....................</p>--%>
    <%--{{7+5}}--%>
    <%--<p>....</p>--%>


    <%--<input type="text" ng-model="name">--%>
    <%--Hi, {{name}}!--%>
    <%--<p></p>--%>

    <%--<a ng-href="#/view1">go to view1</a>--%>
    <%--<div ng-controller="simoCTRL">--%>
      <%--<p>....................</p>--%>
      <%--<button data-ng-click="someThing()">SimlpeTestText</button>--%>
      <%--<p>....................{{simoleCode}}</p>--%>
      <%--<p>....................{{coins}}</p>--%>
      <%--<p>....................</p>--%>
      <%--<a ng-href="#/profile">view1</a>--%>
      <%--<p>....................</p>--%>


    <%--</div>--%>




    <%--<p> webapp describe s index</p>--%>
  <%--<a href="/api">click here</a>--%>

  <%--</div>--%>

<%--</div>--%>



</body>
</html>
