# backend-2nd-cocktail
<div align="center">
<h1>🍸✨Love Cocktail✨🍸</h1> <br>
<p> 당신이 원하는 다양한 칵테일 종류를 보고, 등록, 수정, 삭제할 수 있는 게시판 제작프로젝트입니다.</p><br>

<br>
<h3>Attributers</h3>
  
|<img src="https://avatars.githubusercontent.com/u/81960250?v=4" width=150px>|<img src="https://avatars.githubusercontent.com/u/59523668?v=4" width=150px>|<img src="https://avatars.githubusercontent.com/u/126961013?v=4" width=150px>|
|:---:|:---:|:---:|
|[이소민](https://github.com/purin48)|[박현민](https://github.com/Hmini0101)|[정경연](https://github.com/Cloudyee)|

<br>

  #### 구현 기능
✔️DB cocktail 테이블 리스트 조회 <br>

✔️원하는 칵테일 정보 추가, DB 반영 <br>

✔️정보 수정, 삭제 <br>

  <br><br>
<h3>Used Stacks</h3>
Development tools<br>
  <div>
    <!--
    <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> 
    <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> 
    <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"> 
    <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> !-->
    <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> 
    <img src="https://img.shields.io/badge/vue.js-4FC08D?style=for-the-badge&logo=vue.js&logoColor=white"> 
    <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> 
  </div>  
  <br>
  Team Collaboration Tools<br>
  <div>
    <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
    <img src="https://img.shields.io/badge/Discord-7289DA?style=for-the-badge&logo=discord&logoColor=white">
    <img src="https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=notion&logoColor=white">
  </div>
<br><br>

----

<h3> 구현 페이지</h3>

#### 🍸 칵테일 리스트 페이지
<img src="https://github.com/purin48/backend-2nd-cocktail/assets/126961013/a4b7a560-4c23-4d6d-823a-4554a0005bce" width=1000px>
<br>
<br>

#### 🍸 칵테일 정보 페이지
<img src="https://github.com/purin48/backend-2nd-cocktail/assets/126961013/0ec62851-1e55-4f43-b067-f6e9d54ae599" width=1000px>

-----

<h3>테이블 ERD</h3>
<img src="https://github.com/purin48/backend-2nd-cocktail/assets/126961013/1cd3ddcf-6116-444b-b29e-35ab1b46e3b7" width=500px>
<br><br>
<h3>API 명세서</h3>
<img src="https://github.com/purin48/backend-2nd-cocktail/assets/126961013/07c269be-59f5-4f14-aa58-1f198d09cd02" width=500px>
<br>
</div>

<br><br>
<h3>Trouble shooting</h3>

<b>💥spring boot와 vue의 서버를 연동하는 방법에서 에러와 CORS 이상 발생<br></b>
협업과 자료 조사를 통해 Controller 위에 @CrossOrigin(origins =" vue의 로컬 서버 주소 ")작성하여 해결.<br>
이론적으로만 알던 CORS에 대해 경험하고 공부할 수 있었다.<br>
<br>
<br>
<b>💥vue와 spring boot연동시 proxy 경로를 잘못설정하여 연동되지 않는 상황이 발생 <br></b>
팀원들과 협업하여 각자 자료를 조사, 경로설정 실수로 인한 것임을 알게 됨. 이를 기록하며 더 성장하게 됨<br>
<br>
<br>
<b>💥api를 통해 받아온 데이터 리스트들을 axios로 들고왔을 때, 새로고침시 화면에 리스트가 출력되지 않는 에러 발생<br></b>

```
listData.value.push(item);
```
에러 당시 listData.value가 아닌 listData.push로 바로 작성해주었기 때문임을 깨달았다.
  <br> 흔히 저지를 수 있는 실수를 경험, 기록하며 성장할 수 있었다.
<br>
<br>
<br>
<b>💥입력받은 정보가  JSON내에 객체, JSON으로 쌓여있어 status 500에러가 나는 문제 발생<br></b>
DTO를 통해 객체를 한번 더 돌리며 해결했다. 또한 현재 입력 값이 없는 c_link를 서버에 보내주는 코드를 삭제하여 해결하였다.
<br><br>


