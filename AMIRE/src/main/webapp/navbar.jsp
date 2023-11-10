<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="home.jsp">AMIRE LE BOGOSS</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#">Accueil</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
                </li>
                <c:choose>
                    <%-- For non-logged in users --%>
                    <c:when test="${empty sessionScope.user}">
                        <li class="nav-item">
                            <a class="nav-link" href="login.jsp">Se connecter</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="register.jsp">S'inscrire</a>
                        </li>
                    </c:when>
                    <%-- For logged in users --%>
                    <c:otherwise>
                        <c:choose>
                            <%-- For teacher --%>
                            <c:when test="${user.role == 'Enseignant'}">
                                <li class="nav-item">
                                    <a class="nav-link" href="enseignant">Enseignant</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/besoin?action=listEnseignantBesoin">Postes disponibles</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/candidature?action=getbyenseignant&id=${enseignant.ID}">Mes candidatures</a>
                                </li>
                            </c:when>
                            <c:when test="${user.role == 'Recruteur'}">
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Besoins
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                        <a class="dropdown-item" href="createBesoin.jsp">Créer un besoin</a>
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/besoin?action=list">Liste des besoins</a>
                                    </div>
                                </li>
                            </c:when>
                            <c:when test="${user.role == 'Admin'}">
                                <li class="nav-item">
                                    <a class="nav-link" href="enseignant">Admin</a>
                                </li>
                            </c:when>
                        </c:choose>
                        <li class="nav-item">
                            <a class="nav-link" href="profile.jsp">Profile</a>
                        </li>
                        <li class="nav-item">
                            <form action="utilisateur" method="post">
                                <input type="hidden" name="action" value="logout">
                                <button type="submit" class="nobtn">Logout</button>
                            </form>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>
