package md.scripcenco.temp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import md.scripcenco.model.Action;

@Data
@AllArgsConstructor
@Builder
public class HandTemplate {
    private static Long ID = 1L;
    private Long id;
    private Action thumb;
    private Action index;
    private Action middle;
    private Action ring;
    private Action pinky;

    @SuppressWarnings("unused")
    private static class CustomPersonBuilder extends HandTemplateBuilder {
        @Override
        public HandTemplate build() {
            ID++;
            id(ID);
            return super.build();
        }
    }
}
