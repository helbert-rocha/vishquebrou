<jsp:include page="header.jsp"/>
<jsp:include page="nav.jsp"/>
	<md-content layout="column" layout-align="center center" class="content-size">
    <div class="app-content">
        
        <div class="card card-signin">
            <img class="img-circle profile-img" src="<%= request.getContextPath() %>/img/vixe-quebrou.png">
            <div class="form-control-wrapper">
                    <md-input-container>
                        <H1>Vish Quebrou!</H1>
                        <H3>P�gina n�o encontrada.</H3>
                    </md-input-container>	
                    <div>
                        <a href="<%= request.getContextPath() %>/">In�cio</a>
                    </div>
            </div>
        </div>
    </div>
</md-content>
<jsp:include page="footer.jsp"/>