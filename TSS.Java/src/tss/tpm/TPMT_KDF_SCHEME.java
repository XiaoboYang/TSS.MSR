package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** Table 167 Definition of TPMT_KDF_SCHEME Structure  */
public class TPMT_KDF_SCHEME extends TpmStructure
{
    /** Scheme selector  */
    public TPM_ALG_ID scheme() { return details != null ? details.GetUnionSelector() : TPM_ALG_ID.NULL; }
    
    /** Scheme parameters  */
    public TPMU_KDF_SCHEME details;
    
    public TPMT_KDF_SCHEME() {}
    
    /** @param _details Scheme parameters
     *         (One of [TPMS_KDF_SCHEME_MGF1, TPMS_KDF_SCHEME_KDF1_SP800_56A,
     *         TPMS_KDF_SCHEME_KDF2, TPMS_KDF_SCHEME_KDF1_SP800_108, TPMS_SCHEME_HASH,
     *  TPMS_NULL_KDF_SCHEME])
     */
    public TPMT_KDF_SCHEME(TPMU_KDF_SCHEME _details) { details = _details; }
    
    @Override
    public void toTpm(OutByteBuf buf) 
    {
        if (details == null) return;
        details.GetUnionSelector().toTpm(buf);
        ((TpmMarshaller)details).toTpm(buf);
    }
    
    @Override
    public void initFromTpm(InByteBuf buf)
    {
        int _scheme = buf.readShort() & 0xFFFF;
        details = UnionFactory.create("TPMU_KDF_SCHEME", new TPM_ALG_ID(_scheme));
        details.initFromTpm(buf);
    }
    
    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.buffer();
    }
    
    public static TPMT_KDF_SCHEME fromBytes (byte[] byteBuf) 
    {
        TPMT_KDF_SCHEME ret = new TPMT_KDF_SCHEME();
        InByteBuf buf = new InByteBuf(byteBuf);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static TPMT_KDF_SCHEME fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    public static TPMT_KDF_SCHEME fromTpm (InByteBuf buf) 
    {
        TPMT_KDF_SCHEME ret = new TPMT_KDF_SCHEME();
        ret.initFromTpm(buf);
        return ret;
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPMT_KDF_SCHEME");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "TPMU_KDF_SCHEME", "details", details);
    }
}

//<<<
