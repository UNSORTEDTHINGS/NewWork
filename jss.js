    const editor = ace.edit('editor');
    editor.setOptions({
    useWrapMode: true
    ,highlightActiveLine: false,
    showPrintMargin: false,
    indent_size: 2,
    showGutter:false,
    readOnly:true,
    fontSize:16,
    theme: 'ace/theme/tomorrow_night_eighties',
    mode: 'ace/mode/java'});

    formatCode();
    function formatCode(index) {
    const session = editor.getSession();
    session.setValue(js_beautify(session.getValue(index)));}

