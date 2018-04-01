package model;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.time.Instant;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BlockTest {

    @Test
    public void createInitialBlockTest() {
        Block block = new Block("initial Block", "");
        assertEquals(block.getData(), "initial Block");
        assertEquals(block.getPreviousHash(), "");
    }

    @Test
    public void createBlockChainWithTwoBlocks() throws Exception {
        Block firstBlock = new Block("initial Block", "");
        Block secondBlock = new Block("second Block", firstBlock.getHash());
        assertEquals(secondBlock.getData(), "second Block");
        assertEquals(secondBlock.getPreviousHash(), firstBlock.getHash());
        assertNotEquals(secondBlock.getHash(), firstBlock.getHash());
    }
}

