package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlockchainTest {

    Blockchain blockchain;

    @Before
    public void setUp() throws Exception {
        blockchain = new Blockchain("first block");
    }

    @Test
    public void checkFirstBlockOfChainTest() throws Exception {
        System.out.println(blockchain.printBlockchain());
    }

    @Test
    public void addBlockToChain() throws Exception {
    }

    @Test
    public void printBlockchain() throws Exception {
    }

    @Test
    public void getBlockchain() throws Exception {
    }

}