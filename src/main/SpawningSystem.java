package main;

import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.io.SaveFileReader;
import mindustry.io.SaveVersion;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class SpawningSystem implements SaveFileReader.CustomChunk{
    public SpawningSystem(){
        SaveVersion.addCustomChunk("frostscape-SS", this);
    }

    @Override
    public void read(DataInput stream) throws IOException {
        Reads r = new Reads(stream);
    }

    @Override
    public void write(DataOutput stream) throws IOException {
        Writes w = new Writes(stream);
    }
}
