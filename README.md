[![CI](https://github.com/Borewit/lizzy/actions/workflows/ci.yml/badge.svg)](https://github.com/Borewit/lizzy/actions/workflows/ci.yml)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.borewit/lizzy/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.borewit/lizzy)

# Lizzy

Lizzy is an open source Java library allowing to parse, create, edit,
convert and save almost any type of [multimedia playlist](https://en.wikipedia.org/wiki/Playlist) multimedia playlist.

The currently supported formats are the following: M3U/M3U8/M4U/RAM, ASX/WMX/WVX/WAX, WPL, XSPF, SMIL, RMP, PLS,
B4S/BPL, RSS/MediaRSS, Atom, PLIST, MPCPL, PLA and PLP (see details <a href="docs/formats.md">here</a>).

Two versatile command-line tools are also available (see the [Getting started](#Getting started) guide).

## Origin

Lizzy has been forked from [sourceforge.net/projects/lizzy](https://sourceforge.net/projects/lizzy/)

## Table of contents

1. [Features](#features)
1. [Supported Playlist Formats](#supported-playlist-formats)
1. [License](#license)
1. [Download](#download)
1. [Documentation](#documentation)
1. [Getting started](#getting-started)
1. [Build](#build)

## Features

* Automatic detection of the type of input playlist</li>
* Information on playlist format support by some media players (input and output)</li>
* Physical access to the individual contents of a playlist is not required (performed on demand)</li>
* Information on playlist items (media contents): MIME type, length, duration, width/height</li>
* Powerful yet simple generic playlist representation</li>
* Direct handling of a given specific playlist type (e.g. ASX, WPL) is possible</li>
* Playlist normalization (empty items removal, simplification, reduction)</li>

## Supported Playlist Formats

| Extension        | Playlist type                                                                                                                                                            | 
|------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `.pla`           | iRiver iQuickList File                                                                                                                                                   |
| `.asx`           | [Advanced Stream Redirector (ASX)](https://en.wikipedia.org/wiki/Advanced_Stream_Redirector)                                                                             |
| `.wmx`, `.wax`   | Windows Media Redirector (WMX)                                                                                                                                           |
| `.wpl`           | [Windows Media Player Playlist (WPL)](https://en.wikipedia.org/wiki/Windows_Media_Player_Playlist)                                                                       |
| `.smil`          | [Synchronized Multimedia Integration Language (SMIL)](https://en.wikipedia.org/wiki/Synchronized_Multimedia_Integration_Language), [W3C](https://www.w3.org/AudioVideo/) |                                           |
| `.rss`           | [RSS Document](https://en.wikipedia.org/wiki/RSS)                                                                                                                        |
| `.atom`          | [Atom Document](https://en.wikipedia.org/wiki/Atom_(web_standard)), [RFC4287](https://www.ietf.org/rfc/rfc4287.txt)                                                      |
| `.xspf`          | [XML Shareable Playlist Format (XSPF)](https://xspf.org/)                                                                      |
| `.plist`, `.xml` | [Property list](https://en.wikipedia.org/wiki/Property_list), [iTunes Library File](https://www.xml.com/pub/a/2004/11/03/itunes.html)                                    |
| `.pls`           | [Winamp PLSv2 Playlist](https://en.wikipedia.org/wiki/PLS_(file_format))                                                                                                 |
| `.mpcpl`         | [Media Player Classic](https://en.wikipedia.org/wiki/Media_Player_Classic) Playlist                                                                                      |
| `.plp`           | Sansa Playlist File                                                                                                                                                      |
| `.m3u`, `.m3u8`  | [Winamp M3U](https://en.wikipedia.org/wiki/M3U)                                                                                                                          |
| `.m4u`           | M4U Playlist                                                                                                                                                             |
| `.ram`           | [Real Audio Metadata (RAM)](https://en.wikipedia.org/wiki/RealAudio#File_extensions)                                                                                     |
| `.rmp`           | [Real Metadata Package (RMP)](https://extension.informer.com/rmp/)                                                                                                       |

## License

Lizzy is licensed through a BSD-like licensing model: see the text [LICENSE.txt](LICENSE.txt).

## Download

Check the [GitHub releases](https://github.com/Borewit/lizzy/releases) page.

## Documentation

* The detailed list of currently supported playlist formats is presented [here](docs/formats.md)
* The Lizzy library [Java reference documentation](docs/javadoc/index.html) (javadoc)
* The project version history is <a href="CHANGES">here</a></li>
* Some <a href="docs/dtd/">DTDs</a> and <a href="docs/schema/">XML Schemas</a> that you may find useful</li>
* The <a href="docs/licenses/">licences</a> (and binaries) of the third-party libraries used at run-time</li>

## Getting started

[//]: # (ToDo)

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
