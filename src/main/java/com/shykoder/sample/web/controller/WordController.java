package com.shykoder.sample.web.controller;

import com.shykoder.sample.web.util.WordProcessorUtil;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NotBlank;

/*
 * @auther shykoder
 * @created 3/15/20
 */

@RestController
@RequestMapping(WordController.SAMPLE_BASE_URL)
public class WordController {
    public static final String SAMPLE_BASE_URL="svc/v1/sample/word";

   @RequestMapping(value="/check-pyramid/{word}")
   public boolean checkIfPyramidWordWithPathVar(@PathVariable("word") @NotBlank final String word) {
        return WordProcessorUtil.getInstance().checkIfPyramidWord(word);
    }

    @RequestMapping(value="/check-pyramid", params="input" )
    public String checkIfPyramidWordWithReqParam(@RequestParam("input") String input) {
        return String.valueOf(WordProcessorUtil.getInstance().checkIfPyramidWord(input));
    }

}
