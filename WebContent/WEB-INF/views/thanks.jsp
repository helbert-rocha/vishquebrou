<jsp:include page="header.jsp"/>
<jsp:include page="nav.jsp"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<md-content layout="column" layout-align="center center">
    <div class="app-content">
        
        <div class="card card-signin">
            <img class="img-circle profile-img" src="<%= request.getContextPath() %>/img/vixe-quebrou.png">
            <h3>Muito obrigado! O suporte da empresa já foi acionado. </h3>
        	<a href="<%= request.getContextPath() %>/info" class="md-raised md-primary md-button md-default-theme"><span class="ng-scope">Informar</span><div class="md-ripple-container"></div></a>
        </div>
    </div>
</md-content>
<jsp:include page="footer.jsp"/>