package model;

import com.google.gson.GsonBuilder;
import util.CryptographyUtil;
import util.JsonUtil;

import java.security.NoSuchAlgorithmException;
import java.time.Instant;

public class Block {

    private String hash;
    private String previousHash;
    private String data;
    private Instant timestamp;

    public Block(String data, String previousHash) {
        try {
            this.previousHash = previousHash;
            this.data = data;
            this.timestamp = Instant.now();
            this.hash = calculateHash();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private String calculateHash() throws NoSuchAlgorithmException {
        return CryptographyUtil.applySha256(previousHash + data + timestamp.toEpochMilli());
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

    public Instant getTimestamp() {
        return timestamp;
    }


}
