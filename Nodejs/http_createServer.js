import { createServer } from 'http';

const server = createServer((req, res) => {
    // URL과 HTTP 메소드 확인
    if (req.url === '/user' && req.method === 'GET') {
        // 사용자 데이터 생성
        const googleUserData = {
            id: '123456789',
            name: 'John Doe',
            email: 'johndoe@example.com'
        };

        res.writeHead(200, { 'Content-Type': 'application/json' }); // 응답 헤더 설정
        res.end(JSON.stringify(googleUserData)); // JSON으로 변환하여 응답 본문에 사용자 데이터를 보냄

    } else {
        // Not Found 응답
        res.writeHead(404, { 'Content-Type': 'text/plain' });
        res.end('Not Found');
    }
});

const PORT = 3000;
server.listen(PORT, () => {
    console.log(`Server running at http://localhost:${PORT}/`);
});