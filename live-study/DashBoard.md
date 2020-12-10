## Issue 댓글 작성자 목록

| 참여자| 1주차| 2주차| 3주차| 참여율| 
|---|---|---|---|---| 
| mongzza| :heavy_check_mark:| | :heavy_check_mark:| 66.67%| 
| Damdam22| :heavy_check_mark:| :heavy_check_mark:| :heavy_check_mark:| 100.00%| 

## Issue 댓글 참여자 대시보드 만들기
[GitHug API for Java](https://github-api.kohsuke.org/) 활용
- [maven 레포지토리](https://mvnrepository.com/artifact/org.kohsuke/github-api) 통해 pom.xml에 의존성 추가
  ```XML
  <dependency>
    <groupId>org.kohsuke</groupId>
    <artifactId>github-api</artifactId>
    <version>1.116</version>
  </dependency>
  ```
- property 파일 사용해서 GitHub 계정 정보 설정
  - id와 pw를 입력하는 방식은 추천하지 않는 방법
  - [GitHub 설정](https://github.com/settings/tokens) 페이지에서 액세스토큰 발급 받아서 xxx.properties에 설정
    ```
    oauth=발급받은액세스토큰
    ```
  - **개인 정보이기 때문에 외부에 노출되지 않도록 주의**
  
- 다른 설정 방법이나 자세한 내용은 [문서](https://github-api.kohsuke.org/) 참고

