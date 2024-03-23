import { open } from 'fs/promises';
import { createWriteStream } from 'fs';

async function writeFileUsingStream() {
    try {
        // 파일 핸들을 엽니다. 'w' 모드는 쓰기를 위해 파일을 열며, 파일이 존재하지 않으면 새로 생성합니다.
        const fileHandle = await open('output.txt', 'w');

        // 파일 핸들을 사용하여 쓰기 스트림을 생성합니다.
        const writeStream = createWriteStream(null, { fd: fileHandle.fd });

        // 스트림에 데이터를 씁니다.
        writeStream.write('Hello, world!\n');
        writeStream.write('Another line of text.');

        // 스트림을 종료합니다.
        writeStream.end();

        // 스트림 종료 이벤트를 감지합니다.
        writeStream.on('finish', () => {
            console.log('Finished writing to the file.');
        });

        // 에러 핸들링
        writeStream.on('error', (err) => {
            console.error('An error occurred:', err);
        });
    } catch (err) {
        console.error('Failed to open the file:', err);
    }
}

writeFileUsingStream();