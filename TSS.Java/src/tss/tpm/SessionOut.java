package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** Structure representing a session block in a response buffer [TSS]  */
public class SessionOut extends TpmStructure
{
    /** TPM nonce  */
    public byte[] nonceTpm;
    
    /** Session attributes  */
    public TPMA_SESSION attributes;
    
    /** HMAC value  */
    public byte[] auth;
    
    public SessionOut() {}
    
    /** @param _nonceTpm TPM nonce
     *  @param _attributes Session attributes
     *  @param _auth HMAC value
     */
    public SessionOut(byte[] _nonceTpm, TPMA_SESSION _attributes, byte[] _auth)
    {
        nonceTpm = _nonceTpm;
        attributes = _attributes;
        auth = _auth;
    }
    
    @Override
    public void toTpm(OutByteBuf buf) 
    {
        buf.writeSizedByteBuf(nonceTpm);
        attributes.toTpm(buf);
        buf.writeSizedByteBuf(auth);
    }
    
    @Override
    public void initFromTpm(InByteBuf buf)
    {
        int _nonceTpmSize = buf.readShort() & 0xFFFF;
        nonceTpm = new byte[_nonceTpmSize];
        buf.readArrayOfInts(nonceTpm, 1, _nonceTpmSize);
        int _attributes = buf.readByte();
        attributes = TPMA_SESSION.fromInt(_attributes);
        int _authSize = buf.readShort() & 0xFFFF;
        auth = new byte[_authSize];
        buf.readArrayOfInts(auth, 1, _authSize);
    }
    
    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.buffer();
    }
    
    public static SessionOut fromBytes (byte[] byteBuf) 
    {
        SessionOut ret = new SessionOut();
        InByteBuf buf = new InByteBuf(byteBuf);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static SessionOut fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    public static SessionOut fromTpm (InByteBuf buf) 
    {
        SessionOut ret = new SessionOut();
        ret.initFromTpm(buf);
        return ret;
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("SessionOut");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "byte", "nonceTpm", nonceTpm);
        _p.add(d, "TPMA_SESSION", "attributes", attributes);
        _p.add(d, "byte", "auth", auth);
    }
}

//<<<
