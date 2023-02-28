# Anissia Anime Schedule Mobile
애니메이션 편성표 모뱌일 프로젝트
- https://anissia.net/schedule

# 개발환경
- flutter 및 android 환경 외.
- 현재 android 환경만 사용중.

# 유의사항
- android
  - android studio 사용시
    - 몇 몇 기능을 쓰기 위해선 아래 방법 으로 내부 android studio 를 켜야 한다.
      - project(오른쪽 클릭) -> flutter -> open android module in android studio
      - android module studio (이하 **AMS**) 
    - 배포시 유의사항.  
      - 배포는 **AMS** 에서만 가능하다.
      - build -> Generate Signed Bundle / Apk
      - keystore 정보를 입력 후 빌드된 릴리즈를 google play console 에 배포 해야 한다.

# 기타
- webview 하나 올린 단순 프로젝트
- 공개 프로젝트이며 유사한 앱을 만들 때 참고.
