# Curso de Kotlin con Android 

## Introducción

Este curso está diseñado para que puedas aprender a programar en Kotlin y a desarrollar aplicaciones para Android.

https://github.com/rojaldo/curso_kotlin

## Enlaces de presentaciones

- [Kotlin](https://docs.google.com/presentation/d/1LRtWhIzpWK2Cq3DfXPAyDnGyxjKRqStrW8doUVz7h-o/edit?usp=sharing)
- [patrones de diseño](https://docs.google.com/presentation/d/1wR9NAuB4eTXrYTceEJJnaVjZqbp6Z81f67w7KhoiNbg/edit?usp=sharing)
- [Ejercicios](https://docs.google.com/presentation/d/1GVAFyZRP0hdJY5iw7DdConhupPhMDFK2lhvcENwlH7k/edit?usp=sharing)

## Compilar APK en Android

Abre una terminal.
Navega al directorio raíz de tu proyecto de Android.
Ejecuta el siguiente comando para compilar el proyecto:
    
```bash
./gradlew assembleDebug
```


Este comando compilará el proyecto en modo debug. Si deseas compilar en modo release, puedes usar:

```bash
./gradlew assembleRelease
```

PAra instalr el APK en un dispositivo, puedes usar el siguiente comando:

```bash
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

Si deseas instalar el APK en un emulador, puedes usar el siguiente comando:

```bash
adb -s emulator-5554 install -r app/build/outputs/apk/debug/app-debug.apk
```

Si deseas ver los logs de tu aplicación, puedes usar el siguiente comando:

```bash
adb logcat
```
    