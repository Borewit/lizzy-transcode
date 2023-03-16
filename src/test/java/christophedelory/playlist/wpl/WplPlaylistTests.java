package christophedelory.playlist.wpl;

import christophedelory.playlist.Playlist;
import christophedelory.playlist.SpecificPlaylist;
import christophedelory.util.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static christophedelory.util.TestUtil.checkPlaylistItemSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("WPL Playlist Tests")
public class WplPlaylistTests
{

    @Test
    @DisplayName("Read WPL playlist file")
    public void readWplPlaylist() throws Exception
    {
        Playlist playlist = TestUtil.readPlaylistFrom("test01.wpl");
        assertNotNull(playlist, "playlist");
        assertEquals(10, playlist.getRootSequence().getComponents().length);
        checkPlaylistItemSource(playlist, 0, "expo2008\\edyoh_def.wmv");
        checkPlaylistItemSource(playlist, 1, "expo2008\\le loup est revenu_0001.wmv");
        checkPlaylistItemSource(playlist, 2, "expo2008\\franzyn_def.wmv");
        checkPlaylistItemSource(playlist, 3, "expo2008\\chorale.wmv");
    }

    @Test
    @DisplayName("Read WPL playlist with media having cid & tid attributes")
    public void readWplPlaylistWithCidAndTid() throws Exception
    {
        Playlist playlist = TestUtil.readPlaylistFrom("test03.wpl");
        assertNotNull(playlist, "playlist");
        assertEquals(1, playlist.getRootSequence().getComponents().length);
        checkPlaylistItemSource(playlist, 0, "laure.wma");
    }

    @Test
    @DisplayName("Write to WPL playlist file")
    public void writeWpl() throws Exception
    {
        writeWpl("test01.asx");
    }

    private static void writeWpl(String testFile) throws Exception
    {
        Playlist playlist = TestUtil.readPlaylistFrom(testFile);
        final WplProvider smilProvider = new WplProvider();
        final byte[] smilData;
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream())
        {
            SpecificPlaylist specificPlaylist = smilProvider.toSpecificPlaylist(playlist);
            specificPlaylist.writeTo(byteArrayOutputStream, null);
            smilData = byteArrayOutputStream.toByteArray();
        }
        try(ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(smilData)) {
            Playlist writtenPlaylist = smilProvider.readFrom(byteArrayInputStream).toPlaylist();
            assertEquals(1, writtenPlaylist.getRootSequence().getComponents().length);
            checkPlaylistItemSource(writtenPlaylist, 0, "http://www.johnsmith.com/media/Raging_Tango.mp3");
        }
    }
}