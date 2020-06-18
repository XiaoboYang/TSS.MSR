package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** This command is used to load objects into the TPM. This command is used when both a
 *  TPM2B_PUBLIC and TPM2B_PRIVATE are to be loaded. If only a TPM2B_PUBLIC is to be
 *  loaded, the TPM2_LoadExternal command is used.
 */
public class LoadResponse extends TpmStructure
{
    /** Handle of type TPM_HT_TRANSIENT for the loaded object  */
    public TPM_HANDLE handle;
    
    /** Name of the loaded object  */
    public byte[] name;
    
    public LoadResponse() { handle = new TPM_HANDLE(); }
    
    @Override
    public void toTpm(OutByteBuf buf) 
    {
        handle.toTpm(buf);
        buf.writeSizedByteBuf(name);
    }
    
    @Override
    public void initFromTpm(InByteBuf buf)
    {
        handle = TPM_HANDLE.fromTpm(buf);
        int _nameSize = buf.readShort() & 0xFFFF;
        name = new byte[_nameSize];
        buf.readArrayOfInts(name, 1, _nameSize);
    }
    
    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.buffer();
    }
    
    public static LoadResponse fromBytes (byte[] byteBuf) 
    {
        LoadResponse ret = new LoadResponse();
        InByteBuf buf = new InByteBuf(byteBuf);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static LoadResponse fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    public static LoadResponse fromTpm (InByteBuf buf) 
    {
        LoadResponse ret = new LoadResponse();
        ret.initFromTpm(buf);
        return ret;
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPM2_Load_RESPONSE");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "TPM_HANDLE", "handle", handle);
        _p.add(d, "byte", "name", name);
    }
}

//<<<
