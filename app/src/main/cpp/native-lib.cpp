#include <jni.h>
#include <string>
#include <ctime>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_ndkexample_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jint JNICALL
Java_com_example_ndkexample_MainActivity_add(
        JNIEnv* env,
        jobject /* this */,
        jint a,
        jint b) {
    return a + b;
}


extern "C" JNIEXPORT jint JNICALL
Java_com_example_ndkexample_MainActivity_sub(
        JNIEnv* env,
        jobject /* this */,
        jint a,
        jint b) {
    return a - b;
}

extern "C" JNIEXPORT jint JNICALL
Java_com_example_ndkexample_MainActivity_mult(
        JNIEnv* env,
        jobject /* this */,
        jint a,
        jint b) {
    return a * b;
}

extern "C" JNIEXPORT jint JNICALL
Java_com_example_ndkexample_MainActivity_div(
        JNIEnv* env,
        jobject /* this */,
        jint a,
        jint b) {
    return a / b;
}

extern "C" JNIEXPORT jint JNICALL
Java_com_example_ndkexample_MainActivity_randomNumber(
        JNIEnv* env,
        jobject /* this */,
        jint number) {
    srand((unsigned int) time(0));
    return rand() % number;
}