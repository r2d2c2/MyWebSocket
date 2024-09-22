# 웹 소켓 채팅 
ws를 nginx에서 wss로 변경하여 통신한다

기본적으로 springboot 가이드를 수정 하였으며
app.js
에서 도메인으로 수정 해줘야 사용 가능하다(https)
const stompClient = new StompJs.Client({
    brokerURL: 'wss://xn--4k0b998acvh.xn--h32bi4v.xn--3e0b707e/gs-guide-websocket'
    //자바의 엔드 포인트 연결
});
