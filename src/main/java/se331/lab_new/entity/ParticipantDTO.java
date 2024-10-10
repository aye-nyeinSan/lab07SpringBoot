package se331.lab_new.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ParticipantDTO {
    Long id;
    String name;
    String telNo;

    @Builder.Default
    List<ParticipantEventDTO> eventHistory=new ArrayList<>();

}
