package tss.tpm;

import tss.*;
import java.util.*;

// -----------This is an auto-generated file: do not edit

//>>>

/** Table 13 Defines for SHA1 Hash Values  */
public final class SHA1 extends TpmEnum<SHA1>
{
    // Values from enum _N are only intended to be used in case labels of a switch statement using the result of this.asEnum() method as the switch condition.
    // However, their Java names are identical to those of the constants defined in this class further below,
    // so for any other usage just prepend them with the SHA1. qualifier.
    public enum _N {
        /** Size of digest in octets  */
        DIGEST_SIZE, 
        
        /** Size of hash block in octets  */
        BLOCK_SIZE
    }
    
    private static ValueMap<SHA1> _ValueMap = new ValueMap<SHA1>();
    
    /** These definitions provide mapping of the Java enum constants to their TPM integer values  */
    public static final SHA1
        DIGEST_SIZE = new SHA1(20, _N.DIGEST_SIZE),
        BLOCK_SIZE = new SHA1(64, _N.BLOCK_SIZE);
    
    public SHA1 (int value) { super(value, _ValueMap); }
    
    public static SHA1 fromInt (int value) { return TpmEnum.fromInt(value, _ValueMap, SHA1.class); }
    
    public static SHA1 fromTpm (byte[] buf) { return TpmEnum.fromTpm(buf, _ValueMap, SHA1.class); }
    
    public static SHA1 fromTpm (InByteBuf buf) { return TpmEnum.fromTpm(buf, _ValueMap, SHA1.class); }
    
    public SHA1._N asEnum() { return (SHA1._N)NameAsEnum; }
    
    public static Collection<SHA1> values() { return _ValueMap.values(); }
    
    private SHA1 (int value, _N nameAsEnum) { super(value, nameAsEnum, _ValueMap); }
    
    private SHA1 (int value, _N nameAsEnum, boolean noConvFromInt) { super(value, nameAsEnum, null); }
    
    @Override
    protected int wireSize() { return 4; }
}

//<<<
