<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: KoHguTeP
  Date: 19.03.2019
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование направления</title>
    <link rel="stylesheet" href="css/stylesAirplane.css"/>
    <script src="tables.js"></script>
</head>
<body>
<header>
    <ul>
        <li><a href="/airplane">Самолёт</a></li>
        <li><a href="/company">Компания</a></li>
        <li><a class="active" href="/direction">Направление</a></li>
        <li><a href="/flight">Полёт</a></li>
        <li><a href="/passenger">Пассажир</a></li>
        <li style="float:right"><a href="/">Главная</a></li>
    </ul>
</header>
<div class="description">
    <form action="updDirection" method="post">
        <table class = "tableDirections" align="center" border="1">
            <thead>
            <caption><c:out value="Редактирование направления"></c:out></caption></thead>
            <tbody>
            <tr>
                <td>ID</td>
                <td><input  name="ID_direction" type="number" class="textbox" readonly value="${idToUpd}"></td>
            </tr>
            <tr>
                <td>Откуда</td>
                <td><input name="directionFrom" type="text" placeholder="Откуда" class="textbox" list="cities"></td>
            </tr>
            <tr>
                <td>Куда</td>
                <td><input name="directionTo" type="text" placeholder="Куда" class="textbox" list="cities"></td>
            </tr>
            <tr>
                <td align="center" colspan="2"><button input type="submit" class="design">Изменить</button></td>
            </tr>
            <tr>
                <td align="center" colspan="2"><a href="/direction" class="design">Отмена</a></td>
            </tr>
            </tbody>
        </table>
        <datalist id="cities">
            <option>Moscow			</option>
            <option>Saint Petersburg</option>
            <option>Novosibirsk		</option>
            <option>Yekaterinburg	</option>
            <option>Nizhniy Novgorod</option>
            <option>Samara          </option>
            <option>Omsk            </option>
            <option>Kazan           </option>
            <option>Rostov-na-Donu  </option>
            <option>Chelyabinsk     </option>
            <option>Ufa             </option>
            <option>Volgograd       </option>
            <option>Perm            </option>
            <option>Krasnoyarsk     </option>
            <option>Saratov         </option>
            <option>Voronezh        </option>
            <option>Tol'yatti       </option>
            <option>Krasnodar       </option>
            <option>Ulyanovsk       </option>
            <option>Izhevsk         </option>
            <option>Yaroslavl       </option>
            <option>Barnaul         </option>
            <option>Vladivostok     </option>
            <option>Irkutsk         </option>
            <option>Khabarovsk      </option>
            <option>Khabarovsk Vtoroy </option>
            <option>Orenburg        </option>
            <option>Novokuznetsk    </option>
            <option>Ryazan'         </option>
            <option>Tyumen          </option>
            <option>Lipetsk         </option>
            <option>Penza           </option>
            <option>Naberezhnyye Chelny </option>
            <option>Kalininskiy     </option>
            <option>Astrakhan       </option>
            <option>Makhachkala     </option>
            <option>Tomsk           </option>
            <option>Kemerovo        </option>
            <option>Tula            </option>
            <option>Kirov           </option>
            <option>Cheboksary      </option>
            <option>Kaliningrad     </option>
            <option>Bryansk         </option>
            <option>Ivanovo         </option>
            <option>Magnitogorsk    </option>
            <option>Kursk           </option>
            <option>Tver            </option>
            <option>Nizhny Tagil    </option>
            <option>Stavropol'      </option>
            <option>Ulan-Ude        </option>
        </datalist>
    </form>
</div>
</body>
</html>
