import os
import tensorflow as tf

# 디렉토리 생성
current_dir = os.path.dirname(__file__)
temp_dir = os.path.join(current_dir, 'temp_files')
os.makedirs(temp_dir, exist_ok=True)

# 임시 디렉토리에 몇 개의 텍스트 파일 생성
file_names = ['file1.txt', 'file2.txt', 'file3.txt']
for file_name in file_names:
    file_path = os.path.join(temp_dir, file_name)
    with open(file_path, 'w') as f:
        f.write(f"Contents of {file_name}")

# tf.io.gfile.glob를 사용하여 모든 '.txt' 파일 목록 검색
pattern = os.path.join(temp_dir, '*.txt')
matching_files = tf.io.gfile.glob(pattern)  # 파일 이름을 포함하는 문자열 배열을 리턴함

print("Found files:")
print(matching_files)

# 임시로 생성된 파일과 디렉토리 삭제
for file_name in file_names:
    os.remove(os.path.join(temp_dir, file_name))
os.rmdir(temp_dir)
