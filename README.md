# CustomEntityAPI
Create custom cross-version entities.

# Description
CustomEntityAPI is a Spigot API extension allowing developers to create and spawn custom entities without 
worrying about the server version.

# Features
CustomEntityAPI includes:
- Custom entity creation
- NMS Support from 1.13 to 1.16.1
- Custom entity persistence during restart
- Custom entity behavior
- Custom natural spawn selection

See the [wiki](https://github.com/Iltotore/CustomEntityAPI/wiki) for more information.

# Installation
## Developers
You can import the library using the [release jar](https://github.com/CustomEntityAPI/releases) or a build tool like Gradle:
```gradle
repositories {
  mavenCentral()
}

dependencies {
  implementation 'io.github.iltotore:customentity:version'
}
```

## Server
You need to add the [release jar](https://github.com/CustomEntityAPI/releases) to your plugins.