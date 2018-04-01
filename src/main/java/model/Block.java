package model;

import com.google.gson.GsonBuilder;
import util.CryptographyUtil;
import util.JsonUtil;

import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

public class Block {

    private String hash;
    private String previousHash;
    private String data;
    private long timestamp;

    public Block(String data, String previousHash) {
        try {
            this.previousHash = previousHash;
            this.data = data;
            this.timestamp = new Date().getTime();
            this.hash = calculateHash();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String calculateHash() throws NoSuchAlgorithmException {
        return CryptographyUtil.applySha256(previousHash + data + timestamp);
    }

    public String printHash() {
        return JsonUtil.printObject(this);
    }
    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getData() {
        return data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return Objects.equals(data, block.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
