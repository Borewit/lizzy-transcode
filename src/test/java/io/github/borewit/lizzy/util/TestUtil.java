package io.github.borewit.lizzy.util;

import io.github.borewit.lizzy.playlist.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class TestUtil
{
  public static final Path sampleFolderPath = Paths.get(System.getProperty("user.dir"), "samples");
  public static final Path jsonTestDataPath = sampleFolderPath.resolve("playlists.json");

  private static final Set<String> skipSamples = new HashSet<>(Arrays.asList(
    "test08.smil"
  ));

  public static List<Path> getSamplePaths() throws IOException
  {
    return Files.walk(sampleFolderPath)
      .filter(file -> Files.isRegularFile(file)
        && !file.getFileName().toString().startsWith(".")
        && !skipSamples.contains(file.getFileName().toString())
        && !file.equals(jsonTestDataPath)
      )
      .collect(Collectors.toList());
  }

  public static Playlist readPlaylistFrom(Path playlistPath) throws IOException
  {
    Path absPlaylistPath = playlistPath.isAbsolute() ? playlistPath : sampleFolderPath.resolve(playlistPath);
    SpecificPlaylist specificPlaylist = SpecificPlaylistFactory.getInstance().readFrom(absPlaylistPath);
    assertNotNull(specificPlaylist, String.format("Reading playlist %s", absPlaylistPath.getFileName()));
    return specificPlaylist.toPlaylist();
  }

}
