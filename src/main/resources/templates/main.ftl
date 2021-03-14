<html lang="en">
<body>
<div>
    <form method="post">
        <input type="text" name="text" placeholder="Введите сообщение" />
        <input type="text" name="tag" placeholder="Тэг">
        <button type="submit">Добавить</button>
    </form>
</div>
<div>Список сообщений</div>
<#list messages as message>
    <div>
        <tr class="info" >
            <td>${message.getText()}</td>
            <td>${message.getTag()}</td>
        </tr>
    </div>
</#list>
</body>
</html>