<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 18.09.2015
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app = "mainApp">
<head>
  <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.js"></script>
  <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular-animate.js"></script>
  <script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.13.4.js"></script>
  <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">

  <script src="${pageContext.request.contextPath}/lib/boostrap/bootstrap.js"></script>

  <script src="${pageContext.request.contextPath}/js/index.js"></script>
  <%--<script src="${pageContext.request.contextPath}/js/example.js"></script>--%>

  <title>Coin</title>
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
<div class="container" ng-controller = "CategoryCntr">

<%--///////////////////////////////////////////////////////////////////////////////////////////////////////  --%>
  <script type="text/ng-template" id="addCoin.html">
    <form name="newCoinForm" validate ng-submit="saveCoin()">
    <div class="modal-header">
      <h3 class="modal-title">Add coin</h3>
    </div>
    <div class="modal-body">
      <p>......</p>
      <p>description : <input type="text" ng-model="description" required/></p>
      <p>name : <input type="text" ng-model="name" required/></p>
      <p>year : <input type="number" ng-model="yearCa" name="yearCa" min="1" max="2015" integer required/></p>
        <p>
        <span style="color:red" ng-show="newCoinForm.yearCa.$error.integer">Year is not valid integer</span>
        <span style="color:red" ng-show="newCoinForm.yearCa.$invalid">Year must be in range 0 to 2015</span>
      </p>
      <p></p>
      <p>Category
        <select ng-model="selectedCategoryId" name="selectedCategoryId" required
                ng-options="category.id as category.name for category in categories">
          <option value="">Select category</option>
          <%--<option ng-repeat="category in categories" value="{{category.id}}">{{category.name}}</option>--%>
        </select>
      </p>
      <p>________________________________</p>
      <label>Avers : </label>
      <input type="file" data-fileread="fileImg1" required>
      <p></p>
      <label>Revers : </label>
      <input type="file" data-fileread="fileImg2" required>
      <p></p>
    </div>
    <div class="modal-footer">
      <%--<button class="btn btn-primary" type="button" ng-click="saveCoin()">Save</button>--%>
      <button class="btn btn-primary" type="submit">Save</button>
      <button class="btn btn-warning" type="button" ng-click="cancel()">Cancel</button>
    </div>
    </form>
  </script>
<%--///////////////////////////////////////////////////////////////////////////////////////////////////////  --%>
  <%--///////////////////////////////////////////////////////////////////////////////////////////////////////  --%>
  <script type="text/ng-template" id="viewCoin.html">
    <form name="viewCoinForm" validate ng-submit="saveCoinEdit()">
    <div class="modal-header">
      <h3 class="modal-title">View coin</h3>
    </div>
    <div class="modal-body">
      <div>
        <div><p>{{currentCoin.name}}  {{currentCoin.year}}</p></div>
        <div>
          <img ng-src="${pageContext.request.contextPath}/img/{{currentCoin.id}}a.jpg" border="2" height="255" width="300">
          <img ng-src="${pageContext.request.contextPath}/img/{{currentCoin.id}}r.jpg" border="2" height="255" width="300">
        </div>
        <p> Description : {{currentCoin.description}}</p>
      </div>
      <div>
        <p>Edit : </p>
        <p> description : <input type="text" ng-model="description" required/></p>
        <p>name : <input type="text" ng-model="name" required/></p>
        <p>year : <input type="number" ng-model="yearCa" name="yearCa" min="1" max="2015" integer required/></p>
        <p>
          <span style="color:red" ng-show="viewCoinForm.yearCa.$error.integer">Year is not valid integer</span>
          <span style="color:red" ng-show="viewCoinForm.yearCa.$invalid">Year must be in range 0 to 2015</span>
        </p>
        <p>Category :
          <select ng-options="category.id as category.name for category in categories" ng-model="selectedCategoryId"></select>
        </p>
        <p>________________________________</p>
        <label>Avers : </label>
        <input type="file" data-fileread="fileImg1">
        <p></p>
        <label>Revers : </label>
        <input type="file" data-fileread="fileImg2">
        <p></p>

      </div>
      <button class="btn btn-primary" type="button" ng-click="deleteCoin()">Delete Coin</button>
    <div class="modal-footer">
      <%--<button class="btn btn-primary" type="button" ng-click="saveCoinEdit()">Save</button>--%>
      <button class="btn btn-primary" type="submit">Save</button>
      <button class="btn btn-warning" type="button" ng-click="cancel()">Cancel</button>
    </div>
    </div>
    </form>
  </script>
  <%--///////////////////////////////////////////////////////////////////////////////////////////////////////  --%>

  <button type="button" class="btn btn-default" ng-click="open('lg')">Add Coin</button>
  <div ng-show="selected">Selection from a modal: {{ selected }}</div>

  <div class="row">
    <div class="col-md-3" >
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
      <p>Temp row .......3list</p>
      <p>Temp row .......4list</p>
    </div>

    <div class="col-md-9">
      <div class="thumbnail">
        <div id="contentCoins">
          <article ng-repeat="coin in coinsForView | filter:{category:forFilter}">
            <img ng-src="${pageContext.request.contextPath}/img/{{coin.id}}a.jpg" border="2" height="85" width="100">
            <img ng-src="${pageContext.request.contextPath}/img/{{coin.id}}r.jpg" border="2" height="85" width="100">
            <a ng-href="#" ng-click="openView('lg', coin)">
              <span>description: {{coin.year}} {{coin.name}}  {{coin.description}}</span>
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

</body>
</html>
