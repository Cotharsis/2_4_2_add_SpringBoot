<#macro login path>
<#--    создаем макрос логин с аргументом паф  и пеерменную вставляем в актион-->

    <form action="${path}" method="post">
        <div><label> User Name : <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <!--    накстрока для мусташа-- невидимое поле с выражением мусташ, любой запрос ьез этого токена будет сервеом игнорироваться-->
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div><input type="submit" value="Sign In"/></div>
    </form>
</#macro>


<#macro logout>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <input type="submit" value="Sign Out"/>
</form>

</#macro>