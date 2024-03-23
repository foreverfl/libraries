import { createReadStream } from 'fs';

const readStream = createReadStream('C:\\Users\\forev\\OneDrive\\바탕 화면\\짤방\\만화\\profile.png'); // 파일로부터 읽기 스트림을 생성


// 스트림이 데이터를 받을 때마다 실행될 이벤트 핸들러
// createReadStream에 의해 생성된 스트림은 기본적으로 64KB(64 * 1024 bytes)의 highWaterMark를 가짐
readStream.on('data', (chunk) => {
    console.log('Received a chunk of data:', chunk);
});

// 스트림이 끝에 도달했을 때 실행될 이벤트 핸들러
readStream.on('end', () => {
    console.log('Reached end of the file.');
});

// 스트림에서 에러가 발생했을 때 실행될 이벤트 핸들러
readStream.on('error', (err) => {
    console.error('An error occurred:', err);
});