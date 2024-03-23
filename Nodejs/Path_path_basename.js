// path 모듈을 불러옵니다.
import { basename } from 'path';

const filePath = 'C:\\Users\\forev\\OneDrive\\바탕 화면\\짤방\\만화\\profile.png'; // 파일 경로를 정의
const fileName = basename(filePath);// 전체 경로에서 파일 이름을 추출
console.log('File Name:', fileName); // 파일 이름과 확장자를 제거한 이름을 출력
const fileNameWithoutExt = basename(filePath, '.png'); // 파일 이름에서 확장자를 제거하고 출력
console.log('File Name without Extension:', fileNameWithoutExt); 