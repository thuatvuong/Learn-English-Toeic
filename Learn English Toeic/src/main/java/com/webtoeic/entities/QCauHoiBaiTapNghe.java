package com.webtoeic.entities;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

@Generated("com.querydsl.codegen.EntitySerializer")
public class QCauHoiBaiTapNghe extends EntityPathBase<CauHoiBaiTapNghe> {

     private static final long serialVersionUID = 619184502L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCauHoiBaiTapNghe cauHoiBaiTapNghe = new QCauHoiBaiTapNghe("cauHoiBaiTapNghe");

    public final QBaiTapNghe baiTapNghe;

    public final StringPath cauHoi = createString("cauHoi");

    public final StringPath dapAn_1 = createString("dapAn_1");

    public final StringPath dapAn_2 = createString("dapAn_2");

    public final StringPath dapAn_3 = createString("dapAn_3");

    public final StringPath dapAn_4 = createString("dapAn_4");

    public final StringPath dapAnDung = createString("dapAnDung");

    public final StringPath giaiThich = createString("giaiThich");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath photoName = createString("photoName");

    public final StringPath script = createString("script");

    public final StringPath soThuTu = createString("soThuTu");

    public QCauHoiBaiTapNghe(String variable) {
        this(CauHoiBaiTapNghe.class, forVariable(variable), INITS);
    }


     public QCauHoiBaiTapNghe(Path<? extends CauHoiBaiTapNghe> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCauHoiBaiTapNghe(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCauHoiBaiTapNghe(PathMetadata metadata, PathInits inits) {
        this(CauHoiBaiTapNghe.class, metadata, inits);
    }

    public QCauHoiBaiTapNghe(Class<? extends CauHoiBaiTapNghe> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.baiTapNghe = inits.isInitialized("baiTapNghe") ? new QBaiTapNghe(forProperty("baiTapNghe")) : null;
    }
}
