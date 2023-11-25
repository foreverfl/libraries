# Kaggle에서 TPU 설정하기

import tensorflow as tf
print("Tensorflow version " + tf.__version__)

# AUTOTUNE은 TensorFlow에서 데이터 로딩에 사용되는 파이프라인의 성능을 자동으로 최적화하는 상수
# TensorFlow가 실행 시에 데이터 프리페치(pre-fetching)나 배치 사이즈 결정 등을 자동으로 조정
AUTO = tf.data.experimental.AUTOTUNE

try:
    tpu = tf.distribute.cluster_resolver.TPUClusterResolver()  # 사용 가능한 TPU를 찾음
    print('Running on TPU ', tpu.master())
except ValueError:
    tpu = None

if tpu:
    tf.config.experimental_connect_to_cluster(tpu)  # TPU 클러스터에 연결
    tf.tpu.experimental.initialize_tpu_system(tpu)  # TPU 시스템 초기화
    strategy = tf.distribute.TPUStrategy(tpu)  # TPU에서 모델을 실행하기 위한 분산 전략을 설정
else:
    strategy = tf.distribute.get_strategy()

print("REPLICAS: ", strategy.num_replicas_in_sync)
