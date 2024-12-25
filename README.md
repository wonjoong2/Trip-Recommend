<img src="https://github.com/user-attachments/assets/7f90b44a-2fa0-4105-9160-deee8c49b50b" width="250" height="200" />

## 1.개요
***
* 프로젝트 명 : 떠나자 국내여행!
* 구성 : 1인 개발
* 일정 : 2024.11.25 ~ 2023.12.11 (2주) 
* 개발 언어 : `Java`
* 개발 환경 : `Spring Boot`, `Apache Tomcat`, `Windows 10`, `DBeaver`, `Git/Github`, `JPA`, `Mybatis`
* API: `빠른 로그인(Google)`, `이메일 인증`, `다음 우편번호 서비스`, `Tour API`, `Google Map API`, `Geocoding API`
* 데이터베이스 : `MariaDB`
* 형상관리 : `Github`
+ 간단소개
  + 혼자서도 충분히 국내 여행을 즐길 수 있다! 본인이 관심있는 여행지역과 장소를 관리하고 사람들과 소통할 수 있는 웹서비스를 기획했습니다.

## 2.주요 기능
***
### 1. 로그인 기능
* 일반 로그인 및 빠른 로그인(Google) 구현
* 세션에 로그인 정보 없는 경우 로그인 화면으로 이동
+ 회원가입
  + 회원가입시 필수 입력사항 Validation Check
+ 아이디 찾기
  + 이메일 인증 기능을 통해 회원 아이디 조회
+ 비밀번호 찾기
  + 회원 아이디, 이메일을 이용해 회원 비밀번호 재설정
### 2-1. 마이페이지(개인정보)
* 회원정보 조회
* 회원 정보 변경 가능(비밀번호, 전화번호, 주소, 이메일)
### 2-2. 마이페이지(여행정보)
* 저장한 여행지 목록 조회
* 구글맵으로 내가 저장한 여행지 한눈에 조회 가능
### 3.커뮤니티 페이지
* 게시글 작성,수정,삭제
* 제목 별 검색 기능
* 댓글 기능
### 4.여행 목록 페이지
* 지역 / 시군구 별 여행지 조회
* 조회 이후 관심 있는 장소 저장

## 3.DB 설계
***
![erd](https://github.com/user-attachments/assets/4803bd68-760d-4914-8dbe-d8bf6be1b1b1)
## 4.API 설계
***
### 회원 관련 API
| 기능 | Method | Url | Return |
| --- | --- | --- | --- |
| 사용자 등록 페이지 이동 | /UserRegister | `GET` | 사용자 등록 페이지 |
| 로그인 요청 처리 | /login | `POST` | /BoardList |
| 로그아웃 요청 처리 | /logout | `POST` | 인덱스 페이지로 이동 |
| ID / PW 찾기 페이지 이동 | /UserFindIdPw | `GET` |  ID / PW 찾기 페이지 |
| 비밀번호 변경 요청 처리 | /userUpdatePw | `POST` |  비밀번호 변경 요청 처리 |


### 마이페이지 관련 API
| 기능 | Method | Url | Return |
| --- | --- | --- | --- |
|  마이페이지 이동 | /myPagePop | `GET` | 마이페이지 |
| 내 여행 목록 페이지 이동 | /myTravelPop | `GET` | 내 여행 목록 페이지 |
| 내 여행목록 GoogleMap 페이지 이동 | /myGoogleMapPop | `GET` | 내 여행목록 GoogleMap 페이지 |

### 여행 관련 API
| 기능 | Method | Url | Return |
| --- | --- | --- | --- |
| Travel Course 페이지 이동 | /TravelList | `GET` | Travel Course 페이지 |
| 지역, 시군구 별 여행 api 요청 처리 | /api/travel-api1 | `POST` | 지역, 시군구 별 여행 api 요청 처리 |
| 여행 상세 api 요청 처리 | /api/travel-api2 | `POST` | 여행 상세 api 요청 처리 |
| 시군구 코드 찾기 api 요청 처리 | /api/travel-api3 | `POST` | 시군구 코드 찾기 api 요청 처리 |
