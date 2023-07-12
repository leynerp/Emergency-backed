package com.emergency.configuration.person.mapper;

import com.emergency.configuration.person.domain.entity.DatAgentEntity;
import com.emergency.configuration.person.domain.entity.DatDoctorregistryEntity;
import com.emergency.configuration.person.domain.entity.DatDoctorregistryEntity.DatDoctorregistryEntityBuilder;
import com.emergency.configuration.person.domain.entity.DatPersonEntity;
import com.emergency.configuration.person.domain.entity.DatPersonEntity.DatPersonEntityBuilder;
import com.emergency.configuration.person.domain.entity.DatShipperEntity;
import com.emergency.configuration.person.domain.entity.NomDocumenttypeEntity;
import com.emergency.configuration.person.dto.AgentDto;
import com.emergency.configuration.person.dto.DoctorDto;
import com.emergency.configuration.person.dto.ShipperDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-12T23:42:34+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public DatDoctorregistryEntity doctorDtoToDatDoctorEntity(DoctorDto doctorDto) {
        if ( doctorDto == null ) {
            return null;
        }

        DatDoctorregistryEntityBuilder datDoctorregistryEntity = DatDoctorregistryEntity.builder();

        datDoctorregistryEntity.personEntityDoctor( doctorDtoToDatPersonEntity( doctorDto ) );
        datDoctorregistryEntity.idDoctor( (long) doctorDto.getId_person() );

        return datDoctorregistryEntity.build();
    }

    @Override
    public DoctorDto doctorEntityToDoctorDto(DatDoctorregistryEntity doctorEntity) {
        if ( doctorEntity == null ) {
            return null;
        }

        DoctorDto doctorDto = new DoctorDto();

        if ( doctorEntity.getIdDoctor() != null ) {
            doctorDto.setId_person( doctorEntity.getIdDoctor().intValue() );
        }
        doctorDto.setName( doctorEntityPersonEntityDoctorName( doctorEntity ) );
        doctorDto.setF_last_name( doctorEntityPersonEntityDoctorFirstLastName( doctorEntity ) );
        doctorDto.setS_last_name( doctorEntityPersonEntityDoctorSecLastName( doctorEntity ) );
        doctorDto.setNo_identification( doctorEntityPersonEntityDoctorNoIdentification( doctorEntity ) );
        doctorDto.setDocument_type( doctorEntityPersonEntityDoctorDocumentTypeName( doctorEntity ) );
        doctorDto.setId_document_type( doctorEntityPersonEntityDoctorIdDocumentType( doctorEntity ) );

        return doctorDto;
    }

    @Override
    public DatShipperEntity shipperDtoToDatShipperEntity(ShipperDto shipperDto) {
        if ( shipperDto == null ) {
            return null;
        }

        DatShipperEntity datShipperEntity = new DatShipperEntity();

        datShipperEntity.setPersonEntityShipper( shipperDtoToDatPersonEntity( shipperDto ) );
        datShipperEntity.setIdShipper( (long) shipperDto.getId_person() );
        datShipperEntity.setRegistry( shipperDto.getRegistry() );

        return datShipperEntity;
    }

    @Override
    public ShipperDto shipperEntityToShipperDto(DatShipperEntity shipperEntity) {
        if ( shipperEntity == null ) {
            return null;
        }

        ShipperDto shipperDto = new ShipperDto();

        if ( shipperEntity.getIdShipper() != null ) {
            shipperDto.setId_person( shipperEntity.getIdShipper().intValue() );
        }
        shipperDto.setName( shipperEntityPersonEntityShipperName( shipperEntity ) );
        shipperDto.setF_last_name( shipperEntityPersonEntityShipperFirstLastName( shipperEntity ) );
        shipperDto.setS_last_name( shipperEntityPersonEntityShipperSecLastName( shipperEntity ) );
        shipperDto.setNo_identification( shipperEntityPersonEntityShipperNoIdentification( shipperEntity ) );
        shipperDto.setDocument_type( shipperEntityPersonEntityShipperDocumentTypeName( shipperEntity ) );
        shipperDto.setId_document_type( shipperEntityPersonEntityShipperIdDocumentType( shipperEntity ) );
        shipperDto.setRegistry( shipperEntity.getRegistry() );

        return shipperDto;
    }

    @Override
    public DatAgentEntity agentDtoToDatAgentEntity(AgentDto agentDto) {
        if ( agentDto == null ) {
            return null;
        }

        DatAgentEntity datAgentEntity = new DatAgentEntity();

        datAgentEntity.setPersonEntityAgent( agentDtoToDatPersonEntity( agentDto ) );
        datAgentEntity.setIdAgent( (long) agentDto.getId_person() );
        if ( agentDto.getAgent_number() != null ) {
            datAgentEntity.setAgentNumber( Long.parseLong( agentDto.getAgent_number() ) );
        }

        return datAgentEntity;
    }

    @Override
    public AgentDto agentEntityToAgentDto(DatAgentEntity agentEntity) {
        if ( agentEntity == null ) {
            return null;
        }

        AgentDto agentDto = new AgentDto();

        if ( agentEntity.getIdAgent() != null ) {
            agentDto.setId_person( agentEntity.getIdAgent().intValue() );
        }
        agentDto.setName( agentEntityPersonEntityAgentName( agentEntity ) );
        agentDto.setF_last_name( agentEntityPersonEntityAgentFirstLastName( agentEntity ) );
        agentDto.setS_last_name( agentEntityPersonEntityAgentSecLastName( agentEntity ) );
        agentDto.setNo_identification( agentEntityPersonEntityAgentNoIdentification( agentEntity ) );
        if ( agentEntity.getAgentNumber() != null ) {
            agentDto.setAgent_number( String.valueOf( agentEntity.getAgentNumber() ) );
        }
        agentDto.setDocument_type( agentEntityPersonEntityAgentDocumentTypeName( agentEntity ) );
        agentDto.setId_document_type( agentEntityPersonEntityAgentIdDocumentType( agentEntity ) );

        return agentDto;
    }

    @Override
    public List<AgentDto> agentEntityListToAgentDtoList(List<DatAgentEntity> agentEntityList) {
        if ( agentEntityList == null ) {
            return null;
        }

        List<AgentDto> list = new ArrayList<AgentDto>( agentEntityList.size() );
        for ( DatAgentEntity datAgentEntity : agentEntityList ) {
            list.add( agentEntityToAgentDto( datAgentEntity ) );
        }

        return list;
    }

    @Override
    public List<ShipperDto> shipperEntityListToShipperDtoList(List<DatShipperEntity> shipperEntity) {
        if ( shipperEntity == null ) {
            return null;
        }

        List<ShipperDto> list = new ArrayList<ShipperDto>( shipperEntity.size() );
        for ( DatShipperEntity datShipperEntity : shipperEntity ) {
            list.add( shipperEntityToShipperDto( datShipperEntity ) );
        }

        return list;
    }

    @Override
    public List<DoctorDto> doctorEntityListToDoctorDtoList(List<DatDoctorregistryEntity> doctorEntity) {
        if ( doctorEntity == null ) {
            return null;
        }

        List<DoctorDto> list = new ArrayList<DoctorDto>( doctorEntity.size() );
        for ( DatDoctorregistryEntity datDoctorregistryEntity : doctorEntity ) {
            list.add( doctorEntityToDoctorDto( datDoctorregistryEntity ) );
        }

        return list;
    }

    protected NomDocumenttypeEntity doctorDtoToNomDocumenttypeEntity(DoctorDto doctorDto) {
        if ( doctorDto == null ) {
            return null;
        }

        NomDocumenttypeEntity nomDocumenttypeEntity = new NomDocumenttypeEntity();

        nomDocumenttypeEntity.setName( doctorDto.getDocument_type() );

        return nomDocumenttypeEntity;
    }

    protected DatPersonEntity doctorDtoToDatPersonEntity(DoctorDto doctorDto) {
        if ( doctorDto == null ) {
            return null;
        }

        DatPersonEntityBuilder datPersonEntity = DatPersonEntity.builder();

        datPersonEntity.documentType( doctorDtoToNomDocumenttypeEntity( doctorDto ) );
        datPersonEntity.name( doctorDto.getName() );
        datPersonEntity.firstLastName( doctorDto.getF_last_name() );
        datPersonEntity.secLastName( doctorDto.getS_last_name() );
        datPersonEntity.noIdentification( doctorDto.getNo_identification() );
        datPersonEntity.idDocumentType( doctorDto.getId_document_type() );

        return datPersonEntity.build();
    }

    private String doctorEntityPersonEntityDoctorName(DatDoctorregistryEntity datDoctorregistryEntity) {
        if ( datDoctorregistryEntity == null ) {
            return null;
        }
        DatPersonEntity personEntityDoctor = datDoctorregistryEntity.getPersonEntityDoctor();
        if ( personEntityDoctor == null ) {
            return null;
        }
        String name = personEntityDoctor.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String doctorEntityPersonEntityDoctorFirstLastName(DatDoctorregistryEntity datDoctorregistryEntity) {
        if ( datDoctorregistryEntity == null ) {
            return null;
        }
        DatPersonEntity personEntityDoctor = datDoctorregistryEntity.getPersonEntityDoctor();
        if ( personEntityDoctor == null ) {
            return null;
        }
        String firstLastName = personEntityDoctor.getFirstLastName();
        if ( firstLastName == null ) {
            return null;
        }
        return firstLastName;
    }

    private String doctorEntityPersonEntityDoctorSecLastName(DatDoctorregistryEntity datDoctorregistryEntity) {
        if ( datDoctorregistryEntity == null ) {
            return null;
        }
        DatPersonEntity personEntityDoctor = datDoctorregistryEntity.getPersonEntityDoctor();
        if ( personEntityDoctor == null ) {
            return null;
        }
        String secLastName = personEntityDoctor.getSecLastName();
        if ( secLastName == null ) {
            return null;
        }
        return secLastName;
    }

    private String doctorEntityPersonEntityDoctorNoIdentification(DatDoctorregistryEntity datDoctorregistryEntity) {
        if ( datDoctorregistryEntity == null ) {
            return null;
        }
        DatPersonEntity personEntityDoctor = datDoctorregistryEntity.getPersonEntityDoctor();
        if ( personEntityDoctor == null ) {
            return null;
        }
        String noIdentification = personEntityDoctor.getNoIdentification();
        if ( noIdentification == null ) {
            return null;
        }
        return noIdentification;
    }

    private String doctorEntityPersonEntityDoctorDocumentTypeName(DatDoctorregistryEntity datDoctorregistryEntity) {
        if ( datDoctorregistryEntity == null ) {
            return null;
        }
        DatPersonEntity personEntityDoctor = datDoctorregistryEntity.getPersonEntityDoctor();
        if ( personEntityDoctor == null ) {
            return null;
        }
        NomDocumenttypeEntity documentType = personEntityDoctor.getDocumentType();
        if ( documentType == null ) {
            return null;
        }
        String name = documentType.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long doctorEntityPersonEntityDoctorIdDocumentType(DatDoctorregistryEntity datDoctorregistryEntity) {
        if ( datDoctorregistryEntity == null ) {
            return null;
        }
        DatPersonEntity personEntityDoctor = datDoctorregistryEntity.getPersonEntityDoctor();
        if ( personEntityDoctor == null ) {
            return null;
        }
        Long idDocumentType = personEntityDoctor.getIdDocumentType();
        if ( idDocumentType == null ) {
            return null;
        }
        return idDocumentType;
    }

    protected NomDocumenttypeEntity shipperDtoToNomDocumenttypeEntity(ShipperDto shipperDto) {
        if ( shipperDto == null ) {
            return null;
        }

        NomDocumenttypeEntity nomDocumenttypeEntity = new NomDocumenttypeEntity();

        nomDocumenttypeEntity.setName( shipperDto.getDocument_type() );

        return nomDocumenttypeEntity;
    }

    protected DatPersonEntity shipperDtoToDatPersonEntity(ShipperDto shipperDto) {
        if ( shipperDto == null ) {
            return null;
        }

        DatPersonEntityBuilder datPersonEntity = DatPersonEntity.builder();

        datPersonEntity.documentType( shipperDtoToNomDocumenttypeEntity( shipperDto ) );
        datPersonEntity.name( shipperDto.getName() );
        datPersonEntity.firstLastName( shipperDto.getF_last_name() );
        datPersonEntity.secLastName( shipperDto.getS_last_name() );
        datPersonEntity.noIdentification( shipperDto.getNo_identification() );
        datPersonEntity.idDocumentType( shipperDto.getId_document_type() );

        return datPersonEntity.build();
    }

    private String shipperEntityPersonEntityShipperName(DatShipperEntity datShipperEntity) {
        if ( datShipperEntity == null ) {
            return null;
        }
        DatPersonEntity personEntityShipper = datShipperEntity.getPersonEntityShipper();
        if ( personEntityShipper == null ) {
            return null;
        }
        String name = personEntityShipper.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String shipperEntityPersonEntityShipperFirstLastName(DatShipperEntity datShipperEntity) {
        if ( datShipperEntity == null ) {
            return null;
        }
        DatPersonEntity personEntityShipper = datShipperEntity.getPersonEntityShipper();
        if ( personEntityShipper == null ) {
            return null;
        }
        String firstLastName = personEntityShipper.getFirstLastName();
        if ( firstLastName == null ) {
            return null;
        }
        return firstLastName;
    }

    private String shipperEntityPersonEntityShipperSecLastName(DatShipperEntity datShipperEntity) {
        if ( datShipperEntity == null ) {
            return null;
        }
        DatPersonEntity personEntityShipper = datShipperEntity.getPersonEntityShipper();
        if ( personEntityShipper == null ) {
            return null;
        }
        String secLastName = personEntityShipper.getSecLastName();
        if ( secLastName == null ) {
            return null;
        }
        return secLastName;
    }

    private String shipperEntityPersonEntityShipperNoIdentification(DatShipperEntity datShipperEntity) {
        if ( datShipperEntity == null ) {
            return null;
        }
        DatPersonEntity personEntityShipper = datShipperEntity.getPersonEntityShipper();
        if ( personEntityShipper == null ) {
            return null;
        }
        String noIdentification = personEntityShipper.getNoIdentification();
        if ( noIdentification == null ) {
            return null;
        }
        return noIdentification;
    }

    private String shipperEntityPersonEntityShipperDocumentTypeName(DatShipperEntity datShipperEntity) {
        if ( datShipperEntity == null ) {
            return null;
        }
        DatPersonEntity personEntityShipper = datShipperEntity.getPersonEntityShipper();
        if ( personEntityShipper == null ) {
            return null;
        }
        NomDocumenttypeEntity documentType = personEntityShipper.getDocumentType();
        if ( documentType == null ) {
            return null;
        }
        String name = documentType.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long shipperEntityPersonEntityShipperIdDocumentType(DatShipperEntity datShipperEntity) {
        if ( datShipperEntity == null ) {
            return null;
        }
        DatPersonEntity personEntityShipper = datShipperEntity.getPersonEntityShipper();
        if ( personEntityShipper == null ) {
            return null;
        }
        Long idDocumentType = personEntityShipper.getIdDocumentType();
        if ( idDocumentType == null ) {
            return null;
        }
        return idDocumentType;
    }

    protected NomDocumenttypeEntity agentDtoToNomDocumenttypeEntity(AgentDto agentDto) {
        if ( agentDto == null ) {
            return null;
        }

        NomDocumenttypeEntity nomDocumenttypeEntity = new NomDocumenttypeEntity();

        nomDocumenttypeEntity.setName( agentDto.getDocument_type() );

        return nomDocumenttypeEntity;
    }

    protected DatPersonEntity agentDtoToDatPersonEntity(AgentDto agentDto) {
        if ( agentDto == null ) {
            return null;
        }

        DatPersonEntityBuilder datPersonEntity = DatPersonEntity.builder();

        datPersonEntity.documentType( agentDtoToNomDocumenttypeEntity( agentDto ) );
        datPersonEntity.name( agentDto.getName() );
        datPersonEntity.firstLastName( agentDto.getF_last_name() );
        datPersonEntity.secLastName( agentDto.getS_last_name() );
        datPersonEntity.noIdentification( agentDto.getNo_identification() );
        datPersonEntity.idDocumentType( agentDto.getId_document_type() );

        return datPersonEntity.build();
    }

    private String agentEntityPersonEntityAgentName(DatAgentEntity datAgentEntity) {
        if ( datAgentEntity == null ) {
            return null;
        }
        DatPersonEntity personEntityAgent = datAgentEntity.getPersonEntityAgent();
        if ( personEntityAgent == null ) {
            return null;
        }
        String name = personEntityAgent.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String agentEntityPersonEntityAgentFirstLastName(DatAgentEntity datAgentEntity) {
        if ( datAgentEntity == null ) {
            return null;
        }
        DatPersonEntity personEntityAgent = datAgentEntity.getPersonEntityAgent();
        if ( personEntityAgent == null ) {
            return null;
        }
        String firstLastName = personEntityAgent.getFirstLastName();
        if ( firstLastName == null ) {
            return null;
        }
        return firstLastName;
    }

    private String agentEntityPersonEntityAgentSecLastName(DatAgentEntity datAgentEntity) {
        if ( datAgentEntity == null ) {
            return null;
        }
        DatPersonEntity personEntityAgent = datAgentEntity.getPersonEntityAgent();
        if ( personEntityAgent == null ) {
            return null;
        }
        String secLastName = personEntityAgent.getSecLastName();
        if ( secLastName == null ) {
            return null;
        }
        return secLastName;
    }

    private String agentEntityPersonEntityAgentNoIdentification(DatAgentEntity datAgentEntity) {
        if ( datAgentEntity == null ) {
            return null;
        }
        DatPersonEntity personEntityAgent = datAgentEntity.getPersonEntityAgent();
        if ( personEntityAgent == null ) {
            return null;
        }
        String noIdentification = personEntityAgent.getNoIdentification();
        if ( noIdentification == null ) {
            return null;
        }
        return noIdentification;
    }

    private String agentEntityPersonEntityAgentDocumentTypeName(DatAgentEntity datAgentEntity) {
        if ( datAgentEntity == null ) {
            return null;
        }
        DatPersonEntity personEntityAgent = datAgentEntity.getPersonEntityAgent();
        if ( personEntityAgent == null ) {
            return null;
        }
        NomDocumenttypeEntity documentType = personEntityAgent.getDocumentType();
        if ( documentType == null ) {
            return null;
        }
        String name = documentType.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long agentEntityPersonEntityAgentIdDocumentType(DatAgentEntity datAgentEntity) {
        if ( datAgentEntity == null ) {
            return null;
        }
        DatPersonEntity personEntityAgent = datAgentEntity.getPersonEntityAgent();
        if ( personEntityAgent == null ) {
            return null;
        }
        Long idDocumentType = personEntityAgent.getIdDocumentType();
        if ( idDocumentType == null ) {
            return null;
        }
        return idDocumentType;
    }
}
