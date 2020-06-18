package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** This command starts a hash or an Event Sequence. If hashAlg is an implemented hash,
 *  then a hash sequence is started. If hashAlg is TPM_ALG_NULL, then an Event Sequence is
 *  started. If hashAlg is neither an implemented algorithm nor TPM_ALG_NULL, then the TPM
 *  shall return TPM_RC_HASH.
 */
public class HashSequenceStartResponse extends TpmStructure
{
    /** A handle to reference the sequence  */
    public TPM_HANDLE handle;
    
    public HashSequenceStartResponse() { handle = new TPM_HANDLE(); }
    
    @Override
    public void toTpm(OutByteBuf buf) 
    {
        handle.toTpm(buf);
    }
    
    @Override
    public void initFromTpm(InByteBuf buf)
    {
        handle = TPM_HANDLE.fromTpm(buf);
    }
    
    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.buffer();
    }
    
    public static HashSequenceStartResponse fromBytes (byte[] byteBuf) 
    {
        HashSequenceStartResponse ret = new HashSequenceStartResponse();
        InByteBuf buf = new InByteBuf(byteBuf);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static HashSequenceStartResponse fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    public static HashSequenceStartResponse fromTpm (InByteBuf buf) 
    {
        HashSequenceStartResponse ret = new HashSequenceStartResponse();
        ret.initFromTpm(buf);
        return ret;
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPM2_HashSequenceStart_RESPONSE");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "TPM_HANDLE", "handle", handle);
    }
}

//<<<
