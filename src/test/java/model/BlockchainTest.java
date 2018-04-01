package model;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class BlockchainTest {

    /*using https://medium.com/programmers-blockchain/create-simple-blockchain-java-tutorial-from-scratch-6eeed3cb03fa
    * as example to build my own*/

    Blockchain blockchain;

    @Before
    public void setUp() throws Exception {
        blockchain = new Blockchain("first block");
    }

    @Test
    public void addBlockToChainTest() throws Exception {
        assertTrue(blockchain.addBlockToChain("new block added to chain"));
        assertTrue(blockchain.getBlockchain().contains(new Block("new block added to chain", "")));
        assertEquals(blockchain.getBlockchain().get(0).getData(), "first block");
    }

    @Test
    public void addAnotherBlockToChainTest() throws Exception {
        assertTrue(blockchain.addBlockToChain("another block"));
        assertTrue(blockchain.getBlockchain().contains(new Block("another block", "")));
        assertEquals(blockchain.getBlockchain().get(0).getData(), "first block");
    }

}