<h1>📌 API 명세서</h1>


✅ Base URL: http://localhost:8080/api

<h2>📂 일정 API </h2>

📝 일정 생성

<ul>
  <li>URL: /schedules </li>

  <li>Method: POST</li>
</ul>

✅ Request
````
{
    "title": "hi",
    "content": "play 미팅22",
    "userId": 2
}

````
📤 Response
````
{
    "id": 1,
    "title": "hi",
    "content": "play 미팅22",
    "username": "testuser3",
    "createdAt": "2025-04-05T01:56:15.33391",
    "updatedAt": "2025-04-05T01:56:15.33391"
}
````

-----

📝 전체 일정 조회

<ul>
  <li>URL: /schedules </li>

  <li>Method: GET</li>

</ul>

📤 Response
````
 [
    {
        "id": 1,
        "title": "hi",
        "content": "play 미팅22",
        "username": "testuser3",
        "createdAt": "2025-04-05T01:56:15.33391",
        "updatedAt": "2025-04-05T01:56:15.33391"
    },
    {
        "id": 2,
        "title": "hello",
        "content": "study 미팅22",
        "username": "testuser2",
        "createdAt": "2025-04-05T01:57:20.84692",
        "updatedAt": "2025-04-05T01:57:20.84692"
    }
]
````

-----
📝 일정 단건 조회

<ul>
  <li>URL: /schedules/{id}</li>

  <li>Method: GET</li>

</ul>


📤 Response
````
{
        "id": 1,
        "title": "hi",
        "content": "play 미팅22",
        "username": "testuser3",
        "createdAt": "2025-04-05T01:56:15.33391",
        "updatedAt": "2025-04-05T01:56:15.33391"
    }
````

-----
📝 일정 수정

<ul>
  <li>URL: /schedules/{id}</li>

  <li>Method: PUT</li>

</ul>

✅ Request
````
{
    "title": "업데이트된 회의",
    "content": "새로운 미팅 내용",
    "userId": 1
}
````
📤 Response
````
{
    "id": 2,
    "title": "업데이트된 회의",
    "content": "새로운 미팅 내용",
    "username": "testuser2",
    "createdAt": "2025-04-05T01:57:20.84692",
    "updatedAt": "2025-04-05T01:58:00.631354"
}
````

-----
📝 일정 삭제

<ul>
  <li>URL: /schedule/{id}</li>

  <li>Method: DELETE </li>

</ul>


📤 Response
x

-----

<h2>📂 유저 API</h2>

📝 유저 생성 (회원가입)

<ul>
  <li>URL: /users/register</li>

  <li>Method: POST </li>

</ul>

✅ Request
````
{
    "username": "testuser3",
    "email": "test3@example.com",
    "password": "12345"
}

````
📤 Response
````
{
    "username": "testuser3",
    "email": "test3@example.com",
    "userId": 1,
    "createdAt": "2025-04-05T02:07:44.572922",
    "updatedAt": "2025-04-05T02:07:44.572922"
}
````

-----
📝 전체 유저 조회

<ul>
  <li>URL: /users</li>

  <li>Method: GET </li>

</ul>

📤 Response
````
[
    {
        "username": "testuser3",
        "email": "test3@example.com",
        "userId": 1,
        "createdAt": "2025-04-05T02:07:44.572922",
        "updatedAt": "2025-04-05T02:07:44.572922"
    },
    {
        "username": "useer",
        "email": "seconduser@example.com",
        "userId": 2,
        "createdAt": "2025-04-05T02:12:09.738637",
        "updatedAt": "2025-04-05T02:12:09.738637"
    }
]
````

-----
📝 유저 단건 조회

<ul>
  <li>URL: /users/{id} </li>

  <li>Method: GET </li>

</ul>

📤 Response
````
{
    "username": "testuser3",
    "email": "test3@example.com",
    "userId": 1,
    "createdAt": "2025-04-05T02:07:44.572922",
    "updatedAt": "2025-04-05T02:07:44.572922"
}
````

-----
📝 유저 수정


<ul>
  <li>URL: /users/{id} </li>

  <li>Method: PUT </li>

</ul>


✅ Request
````
{
    "username": "updateduser33",
    "email": "updated@example.com",
    "password": "4321"
}

````
📤 Response
````
{
    "username": "updateduser33",
    "email": "updated@example.com",
    "userId": 2,
    "createdAt": "2025-04-05T02:12:09.738637",
    "updatedAt": "2025-04-05T02:13:18.797909"
}
````

-----
📝 유저 삭제


<ul>
  <li>URL: /users/{id} </li>

  <li>Method: DELETE </li>

</ul>

📤 Response (실패 시)
````
{
    "path": "/api/auth/login",
    "error": "UNAUTHORIZED",
    "message": "해당 유저가 존재하지 않습니다.",
    "timestamp": "2025-04-05T02:27:01.365164",
    "status": 401
}
````

------
<h2>📂 로그인/아웃 </h2>

📝 로그인

<ul>
  <li>URL: /log/login </li>

  <li>Method: POST</li>

</ul>

✅ Request
````
{
    "email": "seconduserddd@example.com",
    "password": "12345"
}
````
📤 Response(성공)
````
{
    "message": "로그인에 성공하였습니다."
}
````
📤 Response(실패)
````
{
    "path": "/api/auth/login",
    "error": "UNAUTHORIZED",
    "message": "이메일 또는 비밀번호가 올바르지 않습니다.",
    "timestamp": "2025-04-05T02:29:25.493099",
    "status": 401
}
````

📤 Response (이메일 틀렸을 때)
````
{
    "path": "/api/auth/login",
    "error": "UNAUTHORIZED",
    "message": "존재하지 않는 이메일입니다.",
    "timestamp": "2025-04-05T02:31:51.163398",
    "status": 401
}
````

-----


📝 로그아웃

<ul>
  <li>URL: /api/logout </li>

  <li>Method: POST</li>

</ul>


📤 Response
````
{
    "message": "로그아웃 되었습니다."
}
````

-----
ERD
------
![img.png](img.png)





