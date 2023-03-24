[![CI](https://github.com/Borewit/lizzy-transcode/actions/workflows/ci.yml/badge.svg)](https://github.com/Borewit/lizzy-transcode/actions/workflows/ci.yml)

# Lizzy Transcode

Lizzy Transcode is an open source Java library command line utility which can
convert and save almost any type of [multimedia playlist](https://en.wikipedia.org/wiki/Playlist).

See the [Lizzy project](https://github.com/Borewit/lizzy#supported-playlist-formats) for the list of support formats.

Two versatile command-line tools are also available (see the [Getting started](#Getting started) guide).

## Origin

Lizzy has been forked from [sourceforge.net/projects/lizzy](https://sourceforge.net/projects/lizzy/)
And this split into two projects:
1. [Lizzy](https://github.com/Borewit/lizzy) Module to read and write playlists formats
2. [Lizzy Transcode](https://github.com/Borewit/lizzy-transcode) Transcode command line application

## License

Lizzy is licensed through a BSD-like licensing model: see the text [LICENSE.txt](LICENSE.txt).

## Download

Check the [GitHub releases](https://github.com/Borewit/lizzy-transcode/releases) page.


## Build

In order to build Lizzy from the sources, you first have to download and install the following tools:

1. Install Java SDK 15 (may work with other versions as well)
1. Install [Gradle](https://gradle.org/)
1. You may have to set `JAVA_HOME` and directory `bin` folder of the Maven installation to
   your [PATH System variable](https://en.wikipedia.org/wiki/PATH_(variable)).

Execute the following command in order to build the distribution and store it in your local Maven cache:

## Build

### Publish local

Publish to local Maven repository:

```shell
./gradlew :clean :publishToMavenLocal
```

### Publish to Maven Central

Publish to local Sonatype Maven Central - Sonatype:

```shell
./gradlew :sign
./gradlew :publish
```
