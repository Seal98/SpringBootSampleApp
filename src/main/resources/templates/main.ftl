<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <div>
        <form method="post" action="add">
            <input type="text" name="text" placeholder="Input message" />
            <input type="text" name="tag" placeholder="Tagg">
            <button type="submit">Add</button>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
        </form>
        <form method="post" action="filter">
            <input type="text" name="tag" placeholder="Tagg">
            <button type="submit">Find</button>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
        </form>
    </div>
    <div>Messages list</div>
    <#list messages as message>
        <div>
            <b>${message.getId()}</b>
            <span>${message.getText()}</span>
            <i>${message.getTag()}</i>
        </div>
    </#list>
    <form method="get" action="nextPage">
        <button>Next page</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </form>
    <form action="/logout" method="post">
        <input type="submit" value="Sign Out"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </form><br>
    <a href="/user">Show users</a>
</@c.page>