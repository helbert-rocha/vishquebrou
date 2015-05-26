<jsp:include page="header.jsp"/>
<jsp:include page="nav.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<md-content layout="column" layout-align="center center" class="content-size">
    <div class="app-content">
        
        <div class="card card-signin">
            <img class="img-circle profile-img" src="<%= request.getContextPath() %>/img/vixe-quebrou.png">
            <div class="form-control-wrapper">
                <form name="loginForm" method="post" action="<%= request.getContextPath() %>/login" >
                    <md-input-container>
                        <label>Usuário</label>
                        <input type="text" ng-required="true" name="username"  value="${user ? "" : user}">
                        <c:if test="${error == true}">
                        <div ng-messages="loginForm.username.$error">
                            	<div ng-message="required">Usuário ou senha inválidos.</div>
                        		</div>
                        </c:if>
                    </md-input-container>
                    <md-input-container>
                        <label>Senha</label>
                        <input type="password" ng-required="true" name="password" ng-model="user.password">
                        <div ng-messages="loginForm.password.$error" ng-show="loginForm.password.$invalid && loginForm.password.$touched">
                            <div ng-message="required">Campo Senha deve ser preenchido.</div>
                        </div>
                    </md-input-container>
                    <div class="loginBtn">
                        <md-button type="submit" class="md-raised md-primary">Entrar</md-button>
                    </div>
						
                    <div>
                        <a class="md-primary md-button md-default-theme" href="<%= request.getContextPath() %>/register">Cadastrar</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</md-content>
<jsp:include page="footer.jsp"/>