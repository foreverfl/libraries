import tensorflow as tf

# 예제 데이터
samples = ['첫 번째 데이터', '두 번째 데이터', '세 번째 데이터']

# TFRecord 파일에 쓰기
with tf.io.TFRecordWriter('example.tfrecord') as writer:
    for sample in samples:
        # 문자열 데이터를 bytes로 변환
        feature = {
            'data': tf.train.Feature(bytes_list=tf.train.BytesList(value=[sample.encode('utf-8')]))
        }

        # tf.train.Example을 통해 Features 생성
        example = tf.train.Example(features=tf.train.Features(feature=feature))

        # TFRecord 파일에 쓰기
        writer.write(example.SerializeToString())
